import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class restoreIpAddresses93 {

    List<String> ret = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return ret;
    }

    public void dfs(String s, int start, int level) {
        if (level > 3) {
            return;
        }
        if (level == 3 && path.size() == 3) {
            String substring = s.substring(start);
            if (!check(substring)) {
                return;
            }
            path.add(substring);
            String ip = "";
            for (String p : path) {
                ip = ip + "." + p;
            }
            ret.add(ip.substring(1));
            path.removeLast();
            return;
        }

        for (int i = 1; i <= 3 && i + start < s.length(); i++) {
            String num = s.substring(start, i + start);
            if (check(num)) {
                path.add(num);
                dfs(s, start + i, level + 1);
                path.removeLast();
            } else {
                break;
            }
        }

    }

    private boolean check(String num) {
        if (num.length() > 1) {
            long i = Long.parseLong(num.substring(0, 1));
            if (i == 0) {
                return false;
            }
        }
        long i = Long.parseLong(num);
        if (i >= 0 && i <= 255) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new restoreIpAddresses93().restoreIpAddresses("25525511135");
    }
}

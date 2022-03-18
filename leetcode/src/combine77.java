import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class combine77 {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(n, 1, k);
        return ret;
    }

    public void combine(int n, int start, int k) {
        if (path.size() == k) {
            ret.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.addLast(i);
            combine(n, i + 1, k);
            path.removeLast();
        }
    }
}

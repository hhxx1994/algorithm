package one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class checkValidString678 {

    Map<String, Boolean> memo = new HashMap<>();
    public boolean checkValidString(String s) {
        return checkValidString(s, 0, 0);
    }

    private boolean checkValidString(String s, int index, int count) {
        int n = s.length();
        if (count < 0 || count > n / 2) {
            return false;
        }
        if (index == n) {
            return count == 0;
        }

        String key = index + "-" + count;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean ans;
        if (s.charAt(index) == '(') {
            ans = checkValidString(s, index + 1, count + 1);
        } else if (s.charAt(index) == ')') {
            ans = checkValidString(s, index + 1, count - 1);
        } else {
            ans = checkValidString(s, index + 1, count)
                    || checkValidString(s, index + 1, count + 1)
                    || checkValidString(s, index + 1, count - 1);
        }

        memo.put(key, ans);
        return ans;
    }

}

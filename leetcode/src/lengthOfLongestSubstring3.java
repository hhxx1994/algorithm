import java.util.HashSet;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class lengthOfLongestSubstring3 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int ret = 0;
        Set<Character> windows = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            windows.add(c);
            while (windows.contains(c)) {
                left++;
                windows.remove(s.charAt(left));
            }
            ret = Math.max(ret, right - left);
        }

        return ret;
    }
}

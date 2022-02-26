import java.util.HashSet;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        Set<Character> window = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            while (window.contains(c)) {
                char d = s.charAt(left);
                left++;
                window.remove(d);
            }
            ret = Math.max(right - left, ret);
            window.add(c);
        }

        return ret;
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int valid = 0;
        int right = 0;
        int left = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            // 更新窗口
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            if (valid == need.size()) {
                return true;
            }

            while (right - left == s1.length()) {
                char d = s2.charAt(left);
                left++;
                // 更新窗口
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.getOrDefault(d, 0) - 1);
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        new CheckInclusion().checkInclusion("abcdxabcde", "abcdeabcdx");
    }
}

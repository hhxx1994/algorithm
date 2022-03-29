import java.util.LinkedList;

/**
 * @author huanghaoxing
 */
public class reverseWords151 {

    // 151. 颠倒字符串中的单词
    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < s.length() && s.charAt(left) == ' ') {
            left++;
        }
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }

        LinkedList<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            if (s.charAt(left) != ' ') {
                sb.append(s.charAt(left));
            } else if (sb.length() > 0) {
                stack.push(sb.toString());
                sb.setLength(0);
            }
            left++;
        }
        stack.push(sb.toString());
        StringBuilder ret = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            ret.append(stack.pop());
            if (i < size - 1) {
                ret.append(" ");
            }
        }

        return ret.toString();
    }
}

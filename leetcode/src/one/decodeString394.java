package one;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @author huanghaoxing
 */
public class decodeString394 {

    // s = "3[a2[c]]"
    int prt = 0;
    String s;

    public String decodeString(String s) {
        this.s = s;
        LinkedList<String> stack = new LinkedList<>();
        while (prt < s.length()) {
            char cur = s.charAt(prt);
            if (Character.isDigit(cur)) {
                // 数字
                int num = getDigit();
                stack.push(num + "");
            } else if (Character.isLetter(cur)) {
                // 字母
                String letter = getLetter();
                stack.push(letter);
            } else if (cur == '[') {
                stack.push(cur + "");
                prt++;
            } else if (cur == ']') {
                prt++;
                StringBuilder str = new StringBuilder();
                while (!"[".equals(stack.peek())) {
                    str.insert(0, stack.pop());
                }
                stack.pop();
                int num = Integer.parseInt(stack.pop());
                StringBuilder mutil = new StringBuilder();
                while (num > 0) {
                    num--;
                    mutil.append(str);
                }
                stack.push(mutil.toString());
            }
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.insert(0, stack.pop());
        }
        return str.toString();
    }


    private String getLetter() {
        StringBuilder letter = new StringBuilder();
        while (prt < s.length() && Character.isLetter(s.charAt(prt))) {
            letter.append(s.charAt(prt));
            prt++;
        }
        return letter.toString();
    }

    private int getDigit() {
        // 数字
        StringBuilder digit = new StringBuilder();
        while (prt < s.length() && Character.isDigit(s.charAt(prt))) {
            digit.append(s.charAt(prt));
            prt++;
        }
        return Integer.parseInt(digit.toString());
    }

    public static void main(String[] args) {
        System.out.println(new decodeString394().decodeString("2[abc]3[cd]ef"));
    }
}

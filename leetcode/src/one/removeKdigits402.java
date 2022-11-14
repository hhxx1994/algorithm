package one;

import java.util.LinkedList;

/**
 * @author huanghaoxing
 */
public class removeKdigits402 {

    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && stack.size() > 0 && stack.peek().compareTo(c) > 0) {
                k--;
                stack.pop();
            }
            stack.push(c);
        }

        while (k > 0) {
            k--;
            stack.pop();
        }
        while (!stack.isEmpty() && stack.peekLast().compareTo('0') == 0) {
            stack.removeLast();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        String ret = sb.toString();
        if(ret.equals("")){
            return "0";
        }
        return ret;
    }
}

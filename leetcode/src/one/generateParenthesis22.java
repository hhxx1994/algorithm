package one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class generateParenthesis22 {

    // 22. 括号生成
    List<String> ret = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generateParenthesis("", n, n);
        return ret;
    }

    public void generateParenthesis(String path, int left, int right) {
        if (left == 0 && right == 0) {
            ret.add(path);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            generateParenthesis(path + "(", left - 1, right);
        }
        if (right > 0) {
            generateParenthesis(path + ")", left, right - 1);
        }
    }
}

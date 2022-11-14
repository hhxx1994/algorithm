package one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class backToOrigin {


    // 备忘录
    Map<String, Integer> memo = new HashMap<>();

    public int backToOrigin(int length, int n) {
        return backToOrigin(0, n, length);
    }

//    // dp[i][j] = dp[(i + 1) % length][j-1] + dp[(index - 1 + length) % length][j-1]
//    // dp[0][n]
//
//    public void dp(int n, int length) {
//
//        int[][] dp = new int[length][n + 1];
//
//
//    }

    public int backToOrigin(int index, int n, int length) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 && index == 0) {
            return 1;
        }
        String key = index + "_" + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ret = 0;
        // 往前
        ret += backToOrigin((index + 1) % length, n - 1, length);
        // 往后
        ret += backToOrigin((index - 1 + length) % length, n - 1, length);

        memo.put(key, ret);
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(new backToOrigin().backToOrigin(10, 2));
    }
}

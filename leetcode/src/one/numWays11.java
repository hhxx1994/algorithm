package one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class numWays11 {
    public int numWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        List<Integer> jumps = new ArrayList<>();
        jumps.add(1);
        jumps.add(2);
        for (int i = 1; i <= n; i++) {
            for (Integer jump : jumps) {
                if (i - jump >= 0) {
                    dp[i] = (dp[i] + dp[i - jump]) % 1000000007;
                }
            }
        }

        return dp[n];
    }
}

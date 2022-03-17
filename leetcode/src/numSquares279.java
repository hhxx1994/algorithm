/**
 * @author huanghaoxing
 */
public class numSquares279 {

    public int numSquares(int n) {
        int nums = (int) Math.sqrt(n);
        int[][] dp = new int[nums + 1][n + 1];
        // dp[...][0] = 0;
        // dp[0][...] = nums + 1;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = n + 1;
        }
        for (int i = 1; i <= nums; i++) {
            for (int j = 0; j <= n; j++) {
                if (j - i * i >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - i * i] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (dp[nums][n] == n + 1) {
            return -1;
        }

        return dp[nums][n];
    }
}

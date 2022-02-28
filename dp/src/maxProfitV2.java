/**
 * @author huanghaoxing
 */
public class maxProfitV2 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][j] : i=天数 j={0:没持有 1:持有}
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }


        return dp[n - 1][0];
    }
}

/**
 * @author huanghaoxing
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int day = prices.length;
        int[][] dp = new int[day][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < day; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[day - 1][0];
    }
}

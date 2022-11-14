package one;

import java.util.Arrays;

/**
 * @author huanghaoxing
 */
public class coinChange322 {

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] d : dp) {
            Arrays.fill(d, amount + 1);
        }

        // base case
        // dp[...][0] = 0
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (dp[coins.length][amount] == amount + 1) {
            return -1;
        }

        return dp[coins.length][amount];
    }

    public int coinChangeV2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }


}

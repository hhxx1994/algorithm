package one;

/**
 * @author huanghaoxing
 */
public class change518 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[amount];
    }
}

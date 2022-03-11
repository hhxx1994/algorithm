package coin;

/**
 * @author huanghaoxing
 */
public class Change518 {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        // base case
        dp[0] = 0;
        int ret = 0;
        for (int i = 0; i < dp.length; i++) {
            // 选择
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = dp[i - coin] + coin;
                    if (dp[i] == amount) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 5};
        new Change518().change(5, ints);
    }
}

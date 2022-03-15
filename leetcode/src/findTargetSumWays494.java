/**
 * @author huanghaoxing
 */
public class findTargetSumWays494 {

    public int findTargetSumWays(int[] nums, int target) {

        int[][] dp = new int[nums.length + 1][target + 1];
        // dp[0][...] = 0;
        // dp[...][0]
        for (int j = 0; j <= target; j++) {
            for (int i = 1; i <= nums.length; i++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j + nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}

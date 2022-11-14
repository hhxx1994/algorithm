package one;

/**
 * @author huanghaoxing
 */
public class findTargetSumWays494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int s = (target + sum) / 2;
        if (s < 0) {
            s = -s;
        }
        int[][] dp = new int[nums.length + 1][s + 1];
        // dp[0][...] = 0
        // dp[...][0] = 1
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            // 注意要从0开始
            for (int j = 0; j <= s; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][s];
    }
}

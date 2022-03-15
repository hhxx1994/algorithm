/**
 * @author huanghaoxing
 */
public class canPartition416 {

    // 二维dp
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int maxNum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }

        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

    public boolean canPartitionV2(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int maxNum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] | dp[i - num];
            }
        }

        return dp[target];
    }

}

import java.util.Arrays;

/**
 * @author huanghaoxing
 */
public class rob213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int i = doRob(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int j = doRob(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(i, j);
    }

    private int doRob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}

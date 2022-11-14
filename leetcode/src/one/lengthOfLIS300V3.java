package one;

import java.util.Arrays;

/**
 * @author huanghaoxing
 */
public class lengthOfLIS300V3 {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ret = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ret = Math.max(ret, dp[i]);
                }
            }
        }
        return ret;
    }
}

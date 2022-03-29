import java.util.Arrays;

/**
 * @author huanghaoxing
 */
public class findLength718 {

    int ret = 0;
    int[][] memo;

    // 718. 最长重复子数组
    public int findLength(int[] nums1, int[] nums2) {
        memo = new int[nums1.length][nums2.length];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        dfs(nums1, nums2, nums1.length - 1, nums2.length - 1);
        return ret;
    }

    public int dfs(int[] nums1, int[] nums2, int i1, int i2) {
        if (i1 < 0 || i2 < 0) {
            return 0;
        }

        if (memo[i1][i2] != -1) {
            return memo[i1][i2];
        }
        dfs(nums1, nums2, i1 - 1, i2);
        dfs(nums1, nums2, i1, i2 - 1);
        if (nums1[i1] == nums2[i2]) {
            int len = dfs(nums1, nums2, i1 - 1, i2 - 1) + 1;
            ret = Math.max(len, ret);
            memo[i1][i2] = len;
            return len;
        }
        memo[i1][i2] = 0;
        return 0;
    }

    public int findLengthV2(int[] nums1, int[] nums2) {
        int ret = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ret = Math.max(ret, dp[i][j]);
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] num1 = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int[] num2 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        new findLength718().findLength(num1, num2);
    }

}

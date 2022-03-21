import java.util.Arrays;

/**
 * @author huanghaoxing
 */
public class minSubArrayLen209 {

    public int minSubArrayLen(int target, int[] nums) {
        int ret = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            right++;

            while (sum >= target) {
                ret = Math.min(ret, right - left);
                sum -= nums[left];
                left++;
            }
        }
        if (ret == Integer.MAX_VALUE) {
            return 0;
        }
        return ret;
    }
}

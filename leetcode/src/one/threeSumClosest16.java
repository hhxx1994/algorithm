package one;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author huanghaoxing
 */
public class threeSumClosest16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(ret - target)) {
                    ret = sum;
                }
                if (sum < target) {
                    start++;
                } else if (sum > target) {
                    end--;
                } else {
                    return sum;
                }
            }
        }

        return ret;

    }


}

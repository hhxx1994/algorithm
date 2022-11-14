package one;

/**
 * @author huanghaoxing
 */
public class maxProduct152 {

    public int maxProduct(int[] nums) {
        int[] mindp = new int[nums.length];
        int[] maxdp = new int[nums.length];
        int max = nums[0];
        mindp[0] = nums[0];
        maxdp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mindp[i] = Math.min(nums[i], Math.min(nums[i] * mindp[i - 1], nums[i] * maxdp[i - 1]));
            maxdp[i] = Math.max(nums[i], Math.max(nums[i] * maxdp[i - 1], nums[i] * mindp[i - 1]));
            max = Math.max(maxdp[i], max);
        }
        return max;
    }
}

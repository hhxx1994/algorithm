package one;

import java.util.Arrays;

/**
 * @author huanghaoxing
 */
public class nextPermutation31 {

    public void nextPermutation(int[] nums) {
        int j = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                j = i - 1;
                break;
            }
        }
        if (j != -1) {
            int k = -1;
            for (int i = j + 1; i < nums.length; i++) {
                if (nums[i] > nums[j]) {
                    k = i;
                }
            }
            if (k != -1) {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                Arrays.sort(nums, j + 1, nums.length);
            } else {
                Arrays.sort(nums);
            }
        } else {
            Arrays.sort(nums);
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 2};
        new nextPermutation31().nextPermutation(ints);
    }

}

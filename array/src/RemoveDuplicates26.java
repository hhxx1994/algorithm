/**
 * @author huanghaoxing
 */
public class RemoveDuplicates26 {

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
                continue;
            }
            slow++;
            nums[slow] = nums[fast];
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 2};
        new RemoveDuplicates26().removeDuplicates(input);
    }
}

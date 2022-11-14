package one;

/**
 * @author huanghaoxing
 */
public class searchRange34 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target <= nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l >= nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        int L = l;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{L, r};
    }
}

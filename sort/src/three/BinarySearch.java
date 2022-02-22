package three;

/**
 * @author huanghaoxing
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length, target);
    }

    // nums[start,end)
    private int search(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return -1;
        }
        if (nums[start] == target) {
            return start;
        }
        int middle = start + (end - start) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] < target) {
            return search(nums, middle + 1, end, target);
        }

        return search(nums, start, middle, target);
    }
}

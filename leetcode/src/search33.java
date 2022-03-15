/**
 * @author huanghaoxing
 */
public class search33 {
    // 33. 搜索旋转排序数组
    public int search(int[] nums, int target) {

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[0] < nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }


        if (nums[0] <= target) {
            r = l - 1;
            l = 0;
        } else {
            r = nums.length - 1;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            }
        }
        return -1;
    }

}

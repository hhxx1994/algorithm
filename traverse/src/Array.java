public class Array {

    public void traverse(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        traverse(nums, 0);
    }

    public void traverse(int[] nums, int i) {
        if (i >= nums.length) {
            return;
        }
        // 前序遍历
        traverse(nums, i + 1);
        // 后序遍历
    }

}

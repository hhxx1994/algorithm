class NumArray {
    int[] ret;

    public NumArray(int[] nums) {
        ret = new int[nums.length + 1];
        for (int i = 1; i < ret.length; i++) {
            ret[i] = ret[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return ret[right + 1] - ret[left];
    }
}
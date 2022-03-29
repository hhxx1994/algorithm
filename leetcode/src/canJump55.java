/**
 * @author huanghaoxing
 */
public class canJump55 {

    // 55. 跳跃游戏
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }

        int maxIndex = 0;
        for (int i = 0; i <= maxIndex; i++) {
            int step = nums[i] + i;
            maxIndex = Math.max(step, maxIndex);
            if (maxIndex >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

}

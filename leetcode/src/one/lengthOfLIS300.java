package one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class lengthOfLIS300 {

    /**
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/yi-bu-yi-bu-tui-dao-chu-guan-fang-zui-you-jie-fa-x/
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        ret.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            boolean add = false;
            for (int j = 0; j < ret.size(); j++) {
                if (nums[i] < ret.get(j)) {
                    add = true;
                    ret.set(j, nums[i]);
                    break;
                }
            }
            if (!add) {
                ret.add(nums[i]);
            }

        }
        return ret.size();
    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 3, 2, 3};
        new lengthOfLIS300().lengthOfLIS(ints);
    }
}

package one;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class longestConsecutive128 {

    // 128. 最长连续序列
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ret = 1;
        for (int num : nums) {
            int cur = num;
            int count = 0;
            if (!set.contains(cur - 1)) {
                while (set.contains(cur)) {
                    count++;
                    cur++;
                }
                ret = Math.max(count, ret);
            }
        }

        return ret;
    }
}

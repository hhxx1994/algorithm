package one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class lengthOfLIS300V2 {

    public int lengthOfLIS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int ret = 0;
            for (int key : map.keySet()) {
                if (key < nums[i]) {
                    ret = Math.max(map.get(key), ret);
                }
            }
            if (ret != 0) {
                max = Math.max(max, ret + 1);
                map.put(nums[i], ret + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        return max;
    }
}

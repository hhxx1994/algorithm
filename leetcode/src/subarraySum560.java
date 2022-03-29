import java.util.*;

/**
 * @author huanghaoxing
 */
public class subarraySum560 {

    // 560. 和为 K 的子数组
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            if (map.containsKey(preSum[i] - k)) {
                ret += map.get(preSum[i] - k);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }

        return ret;
    }


}

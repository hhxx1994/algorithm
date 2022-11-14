package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class subsetsWithDup90 {

    List<List<Integer>> ret = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDup(nums, 0);
        return ret;
    }

    public void subsetsWithDup(int[] nums, int start) {
        ret.add(new LinkedList<>(path));
        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }

            path.addLast(nums[i]);
            subsetsWithDup(nums, i + 1);
            path.removeLast();
        }

    }
}

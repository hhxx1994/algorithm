import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class subsets78 {

    List<List<Integer>> ret = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subset(nums, 0);
        return ret;
    }

    public void subset(int[] nums, int start) {
        ret.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            subset(nums, i + 1);
            path.removeLast();
        }
    }

}

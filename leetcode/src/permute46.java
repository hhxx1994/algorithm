import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class permute46 {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        backtrack(nums, new ArrayList<>());
        return ret;

    }

    public void backtrack(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }

        for (int n : nums) {
            if (path.contains(n)) {
                continue;
            }
            path.add(n);
            backtrack(nums, path);
            path.remove(path.size() - 1);
        }
    }
}

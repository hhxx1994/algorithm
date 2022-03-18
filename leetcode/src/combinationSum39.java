import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class combinationSum39 {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, 0, target);
        return ret;
    }

    public void combinationSum(int[] candidates, int start, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ret.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            combinationSum(candidates, i, target - candidates[i]);
            path.removeLast();
        }
    }

}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class combinationSum2_40 {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates, 0, target);
        return ret;
    }


    public void combinationSum2(int[] candidates, int start, int target) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            ret.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.addLast(candidates[i]);
            combinationSum2(candidates, i + 1, target - candidates[i]);
            path.removeLast();
        }
    }


}

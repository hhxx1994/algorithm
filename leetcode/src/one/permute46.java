package one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class permute46 {

    LinkedList<Integer> path = new LinkedList<>();
    boolean[] visited;
    List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        backtrack(nums);
        return ret;
    }

    public void backtrack(int[] nums) {

        if (path.size() == nums.length) {
            ret.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            path.addLast(nums[i]);
            backtrack(nums);
            visited[i] = false;
            path.removeLast();
        }
    }
}

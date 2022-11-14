package one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class pathSum113 {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return ret;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        targetSum -= node.val;
        if (targetSum == 0 && node.right == null && node.left == null) {
            ret.add(new ArrayList<>(path));
            // 回溯
            path.remove(path.size() - 1);
            return;
        }

        dfs(node.left, targetSum, path);
        dfs(node.right, targetSum, path);
        path.remove(path.size() - 1);
    }
}

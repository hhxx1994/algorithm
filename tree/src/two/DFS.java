package two;

/**
 * @author huanghaoxing
 */
public class DFS {

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        // pre
        dfs(node.left);
        // inOrder
        dfs(node.right);
        // post
    }
}

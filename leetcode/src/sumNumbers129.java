/**
 * @author huanghaoxing
 */
public class sumNumbers129 {

    int ret = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ret;
    }

    public void dfs(TreeNode node, int sum) {

        if (node.left == null && node.right == null) {
            ret += sum;
            return;
        }

        sum = sum * 10 + node.val;
        if (node.left != null) {
            dfs(node.left, sum);
        }

        if (node.right != null) {
            dfs(node.right, sum);
        }

    }
}

package three;

/**
 * @author huanghaoxing
 */
public class Flatten {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        f(root);
    }

    public TreeNode f(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode left = f(node.left);
        TreeNode right = f(node.right);

        if (left != null && right != null) {
            node.right = left;
            node.left = null;
            TreeNode n = findRight(left);
            n.right = right;
        } else if (left != null) {
            node.right = left;
            node.left = null;
        }

        return node;
    }

    public TreeNode findRight(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return findRight(node.right);
    }

}

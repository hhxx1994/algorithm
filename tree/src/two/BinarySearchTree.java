package two;

/**
 * @author huanghaoxing
 */
public class BinarySearchTree {

    public TreeNode add(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = add(node.left, val);
        }
        if (node.val < val) {
            node.right = add(node.right, val);
        }

        return node;
    }

    public TreeNode remove(TreeNode node, int val) {

        if (node == null) {
            return null;
        }
        // 本节点
        if (node.val == val) {
            if (node.left == null) {
                TreeNode right = node.right;
                node.right = null;
                return right;
            } else if (node.right == null) {
                TreeNode left = node.left;
                node.left = null;
                return left;
            } else {
                TreeNode minNode = findMin(node.right);
                minNode.right = removeMin(node.right);
                minNode.left = node.left;
            }

        } else if (val < node.val) {
            // 上一节点
            node.left = remove(node.left, val);
        } else {
            node.right = remove(node.right, val);
        }

        return node;
    }

    private TreeNode removeMin(TreeNode node) {

        // 本节点
        if (node.left == null) {
            TreeNode right = node.right;
            node.right = null;
            return right;
        }
        // 上一节点
        node.left = removeMin(node.left);
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }

        return findMin(node.left);
    }


}

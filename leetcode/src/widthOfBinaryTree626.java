import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class widthOfBinaryTree626 {

    public int widthOfBinaryTree(TreeNode root) {
        int ret = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        root.val = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    queue.add(node.right);
                }
                if (size > 1) {
                    if (i == 0) {
                        start = node.val;
                    }
                    if (i == size - 1) {
                        end = node.val;
                        ret = Math.max(end - start + 1, ret);
                    }
                }

            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        new widthOfBinaryTree626().widthOfBinaryTree(root);
    }
}

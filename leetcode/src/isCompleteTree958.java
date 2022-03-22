import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class isCompleteTree958 {

    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isNull = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node == null) {
                    isNull = true;
                    continue;
                }
                if (isNull) {
                    return false;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;
    }
}

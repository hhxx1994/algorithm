
import java.util.*;

/**
 * @author huanghaoxing
 */
public class zigzagLevelOrder103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int dir = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> r = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node == null) {
                    continue;
                }
                r.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            }
            if (r.size() > 0) {
                if (dir % 2 == 0) {
                    ret.add(r);
                } else {
                    Collections.reverse(r);
                    ret.add(r);
                }
            }
            dir++;
        }

        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        new zigzagLevelOrder103().zigzagLevelOrder(root);
    }
}

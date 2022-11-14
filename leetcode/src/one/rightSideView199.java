package one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class rightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean add = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node == null) {
                    continue;
                }
                if (!add) {
                    ret.add(node.val);
                    add = true;
                }
                queue.add(node.right);
                queue.add(node.left);
            }

        }
        return ret;

    }
}

package two;

/**
 * @author huanghaoxing
 */
public class BinarySearchTree {

    public Node add(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (val < node.val) {
            node.left = add(node.left, val);
        }
        if (node.val < val) {
            node.right = add(node.right, val);
        }

        return node;
    }

    public Node remove(Node node, int val) {

        if (node == null) {
            return null;
        }
        // 本节点
        if (node.val == val) {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                return right;
            } else if (node.right == null) {
                Node left = node.left;
                node.left = null;
                return left;
            } else {
                Node minNode = findMin(node.right);
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

    private Node removeMin(Node node) {

        // 本节点
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            return right;
        }
        // 上一节点
        node.left = removeMin(node.left);
        return node;
    }

    private Node findMin(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }

        return findMin(node.left);
    }


}

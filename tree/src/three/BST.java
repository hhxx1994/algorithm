package three;

import org.omg.CORBA.FREE_MEM;

/**
 * @author huanghaoxing
 */
public class BST {
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    Node root = null;

    public void add(int val) {
        root = add(root, val);
    }

    private Node add(Node node, int val) {

        if (node == null) {
            return new Node(val);
        }
        if (node.val == val) {
            return node;
        }
        if (node.val > val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }

        return node;

    }

    public void remove(int val) {
        root = remove(root, val);
    }

    private Node remove(Node node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val < val) {
            node.right = remove(node.right, val);
        }
        if (node.val > val) {
            node.left = remove(node.left, val);
        }

        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            return left;
        } else if (node.left == null) {
            Node right = node.right;
            node.right = null;
            return right;
        } else {
//            Node minNode = findMin(node.right);
//            removeMin(node.right);
//            minNode.right = node.right;
//            minNode.left = node.left;
//            node.right = null;
//            node.left = null;
//            return minNode;
            return null;
        }
    }


}

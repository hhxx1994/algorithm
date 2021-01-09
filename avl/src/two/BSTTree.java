package two;

/**
 * @author huanghaoxing
 */
public class BSTTree {

    class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    Node root;

    public void add(int data) {
        root = add(data, root);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }


    private Node add(int data, Node node) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = add(data, node.left);
        } else if (node.data < data) {
            node.right = add(data, node.right);
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        // LL
        if (getBalanceFactor(node) > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        // RR
        if (getBalanceFactor(node) < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        // LR
        if (getBalanceFactor(node) > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (getBalanceFactor(node) < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        x.right = y;
        y.left = T3;

        y.height = Math.max(getHeight(y.left), getBalanceFactor(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    private Node leftRotate(Node y) {
        Node x = y.left;
        Node T3 = x.left;

        x.left = y;
        y.right = T3;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }


    public static void main(String[] args) {
        BSTTree bstTree = new BSTTree();
        bstTree.add(5);
        bstTree.add(6);
        bstTree.add(7);
        bstTree.add(2);
        bstTree.add(8);
        bstTree.add(9);
    }

}

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

    private void setHeight(int height, Node node) {
        node.height = height;
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
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        setHeight(Math.max(leftHeight, rightHeight) + 1, node);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            // unbalance
            System.out.println("unbalance");
        }

        return node;
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

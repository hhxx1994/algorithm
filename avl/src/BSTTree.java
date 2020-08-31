/**
 * @author huanghaoxing
 */
public class BSTTree {

  class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
      this.val = val;
    }
  }

  Node root;

  public Node insert(int val) {
    if (root == null) {
      root = new Node(val);
      return root;
    }

    return insert(root, val);
  }

  private Node insert(Node node, int val) {
    if (node == null) {
      return new Node(val);
    }

    if (node.val < val) {
      node.right = insert(node.right, val);
    } else if (val < node.val) {
      node.left = insert(node.left, val);
    }
    return node;
  }


  public void remove(int val) {
    Node node = find(val);
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {

    }
  }

  private Node find(int val) {
    if (root == null)
      return null;
    return find(root, val);
  }

  private Node find(Node node, int val) {
    if (node == null) {
      return null;
    }
    if (node.val < val) {
      return find(node.right, val);
    } else if (val < node.val) {
      return find(node.right, val);
    }
    return node;
  }


  public static void main(String[] args) {
    BSTTree bstTree = new BSTTree();
    bstTree.insert(6);
    bstTree.insert(3);
    bstTree.insert(9);
    bstTree.insert(10);
    bstTree.insert(2);
    bstTree.insert(1);

  }


}

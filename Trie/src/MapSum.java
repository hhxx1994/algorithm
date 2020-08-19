import java.util.HashMap;
import java.util.Map;

public class MapSum {

  class Node {
    int val;
    Map<Character, Node> next = new HashMap<>();

    public Node() {
    }

    public Node(int val) {
      this.val = val;
    }
  }

  /**
   * Initialize your data structure here.
   */
  public MapSum() {
    root = new Node();
  }

  Node root;


  public void insert(String key, int val) {
    Node node = root;
    for (char c : key.toCharArray()) {
      if (!node.next.containsKey(c)) {
        Node cnode = new Node();
        node.next.put(c, cnode);
        node = cnode;
      } else {
        node = node.next.get(c);
      }
    }
    node.val = val;
  }

  public int sum(String prefix) {
    Node node = root;
    for (char c : prefix.toCharArray()) {
      node = node.next.get(c);
      if (node == null) {
        return 0;
      }
    }

    return sum(node);
  }

  private int sum(Node node) {
    int ret = node.val;
    for (Map.Entry<Character, Node> entry : node.next.entrySet()) {
      ret += sum(entry.getValue());
    }
    return ret;
  }
}

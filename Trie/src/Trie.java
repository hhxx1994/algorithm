import java.util.HashMap;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class Trie {

  class Node {
    private boolean isWord;
    private Map<Character, Node> next = new HashMap<>();
  }

  private Node root;
  private int size;

  public Trie() {
    root = new Node();
  }

  public void insert(String word) {
    Node node = root;
    for (char c : word.toCharArray()) {
      if (!node.next.containsKey(c)) {
        Node cnode = new Node();
        node.next.put(c, cnode);
        node = cnode;
      } else {
        node = node.next.get(c);
      }
    }
    node.isWord = true;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apply");
    trie.insert("apple");
    trie.insert("app");
    trie.insert("bdfefe");
  }

}

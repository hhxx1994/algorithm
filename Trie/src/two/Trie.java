package two;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanghaoxing
 * 前缀树
 */
public class Trie {

    class Node {
        boolean isWord;
        Map<Character, Node> next = new HashMap<>();
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.next.containsKey(c)) {
                node.next.put(c, new Node());
            }
            node = node.next.get(c);
        }
        node.isWord = true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("pan");
        trie.insert("panda");
    }


}

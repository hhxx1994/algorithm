package three;

import java.util.HashMap;
import java.util.Map;

class Trie {

    class Node {
        boolean isWord;
        Map<Character, Node> child = new HashMap<>();
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.child.containsKey(c)) {
                node.child.put(c, new Node());
            }
            node = node.child.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.child.containsKey(c)) {
                return false;
            }
            node = node.child.get(c);
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.child.containsKey(c)) {
                return false;
            }
            node = node.child.get(c);
        }
        return true;
    }
}
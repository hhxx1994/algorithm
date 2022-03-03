package one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node pre;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> keyMap;
    Node head;
    Node tail;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyMap = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;

    }

    public int get(int key) {
        Node node = keyMap.get(key);
        if (node == null) {
            return -1;
        }
        put(node.key, node.val);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = keyMap.get(key);
        if (node != null) {
            // node 存在
            remove(node);
            put(key, value);
        } else {
            if (size == capacity) {
                // 先淘汰, 淘汰链表的结尾
                remove(tail.pre);
            }
            // 添加
            add(new Node(key, value));
        }
    }

    private void add(Node node) {
        size++;
        keyMap.put(node.key, node);
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.pre = head;
        next.pre = node;
    }

    private void remove(Node node) {
        size--;
        keyMap.remove(node.key);
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        node.pre = null;
        node.next = null;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
    }
}

package two;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class LRU {

    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }

        public Node() {
        }

        ;
    }

    Map<Integer, Node> cache = new HashMap<>();
    int capacity;
    int size;
    Node head;
    Node tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        Node node = cache.get(key);
        if (node == null) {
            if (size == capacity) {
                Node remove = tail.pre;
                remove(remove);
                cache.remove(remove.key);
                add(key, val);
            } else {
                add(key, val);
                size++;
            }
        } else {
            node.val = val;
            remove(node);
            moveToHead(node);
        }
    }

    private void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;
        node.pre = null;
        node.next = null;

    }

    private void add(int key, int val) {
        Node newNode = new Node(key, val);
        cache.put(key, newNode);
        moveToHead(newNode);
    }

    private void moveToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.pre = head;
        next.pre = node;
    }

    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.get(1);
        lru.put(3, 3);
        lru.get(2);
        lru.put(4, 4);
        lru.get(1);
        lru.get(2);
        lru.get(3);

    }
}

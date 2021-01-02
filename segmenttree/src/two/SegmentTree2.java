package two;

/**
 * @author huanghaoxing
 */
public class SegmentTree2 {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    int[] arr;
    Node root;

    public SegmentTree2(int[] arr) {
        this.arr = arr;
        root = buildSegmentTree(0, arr.length - 1, arr);
    }

    private Node buildSegmentTree(int l, int r, int[] arr) {
        if (l == r) {
            return new Node(arr[l]);
        }

        int mid = l + (r - l) / 2;
        Node left = buildSegmentTree(l, mid, arr);
        Node right = buildSegmentTree(mid + 1, r, arr);
        Node node = new Node(left.data + right.data);
        node.left = left;
        node.right = right;
        return node;
    }


    public int query(int l, int r) {
        return query(l, r, 0, arr.length - 1, root);
    }

    private int query(int l, int r, int treeL, int treeR, Node node) {
        if (l == treeL && r == treeR) {
            return node.data;
        }

        int mid = treeL + (treeR - treeL) / 2;
        if (r <= mid) {
            return query(l, r, treeL, mid, node.left);
        } else if (mid < l) {
            return query(l, r, mid + 1, treeR, node.right);
        } else {
            return query(l, mid, treeL, mid, node.left) + query(mid + 1, r, mid + 1, treeR, node.right);
        }

    }


    public void update(int index, int data) {
        arr[index] = data;

    }

    // [l ... r] ==> node
    private void update(int index, int data, int l, int r, Node node) {
        if (l == r) {
            node.data = data;
            return;
        }

        int mid = l + (r - l) / 2;
        if (index < mid) {
            update(index, data, l, mid, node.left);
        } else {
            update(index, data, mid + 1, r, node.right);
        }
        node.data = node.left.data + node.right.data;
    }

    public static void main(String[] args) {
        SegmentTree2 segmentTree2 = new SegmentTree2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(segmentTree2.query(2, 4));
    }


}

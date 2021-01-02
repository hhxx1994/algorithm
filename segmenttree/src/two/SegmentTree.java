package two;

/**
 * @author huanghaoxing
 * 线段树
 */
public class SegmentTree {

    int[] arr;
    int[] tree;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        this.tree = new int[arr.length * 4];
        buildSegmentTree(0, arr.length - 1, 0);
    }

    // arr[l...r]
    private void buildSegmentTree(int l, int r, int treeIndex) {
        // base case
        if (l == r) {
            tree[treeIndex] = arr[l];
            return;
        }

        int mid = l + (r - l) / 2;
        // arr[l .. mid]
        buildSegmentTree(l, mid, left(treeIndex));
        // arr[mid + 1 .. r]
        buildSegmentTree(mid + 1, r, right(treeIndex));
        tree[treeIndex] = tree[left(treeIndex)] + tree[right(treeIndex)];
    }

    public int sum(int l, int r) {
        // arr[l .. r]
        return sum(l, r, 0, arr.length - 1, 0);
    }

    public int sum(int l, int r, int treeL, int treeR, int treeIndex) {
        //base case
        if (l == treeL && r == treeR) {
            return tree[treeIndex];
        }
        int mid = treeL + (treeR - treeL) / 2;
        if (r <= mid) {// arr[treeL .. mid]
            return sum(l, r, treeL, mid, left(treeIndex));
        } else if (mid < l) { // arr[mid + 1 , treeR]
            return sum(l, r, mid + 1, treeR, right(treeIndex));
        } else {
            return sum(l, mid, treeL, mid, left(treeIndex)) + sum(mid + 1, r, mid + 1, treeR, right(treeIndex));
        }
    }


    public void update(int index, int data) {
        arr[index] = data;
        update(index, data, 0, arr.length - 1, 0);
    }

    private void update(int index, int data, int l, int r, int treeIndex) {
        // base case , 叶子节点
        if (l == r) {
            tree[treeIndex] = data;
        }
        int mid = l + (r - l) / 2;
        if (index <= mid) {
            update(index, data, l, mid, left(treeIndex));
        } else {
            update(index, data, mid + 1, r, right(treeIndex));
        }
        tree[treeIndex] = tree[left(treeIndex)] + tree[right(treeIndex)];

    }


    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }


}

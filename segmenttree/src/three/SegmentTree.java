package three;

/**
 * @author huanghaoxing
 */
public class SegmentTree {
    int[] tree;
    int[] data;

    public SegmentTree(int[] data) {
        this.data = data;
        tree = new int[4 * data.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int start, int end) {
        if (start == end) {
            tree[treeIndex] = data[start];
            return;
        }

        int middle = start + (end - start) / 2;
        int left = left(treeIndex);
        int right = right(treeIndex);
        buildSegmentTree(left, start, middle);
        buildSegmentTree(right, middle + 1, end);
        tree[treeIndex] = tree[left] + tree[right];
    }

    public int query(int l, int r) {
        return query(0, l, r, 0, data.length - 1);
    }

    private int query(int treeIndex, int queryL, int queryR, int start, int end) {
        if (queryL == start && queryR == end) {
            return tree[treeIndex];
        }

        int middle = start + (end - start) / 2;
        if (middle <= queryR) {
            return query(left(treeIndex), queryL, queryR, start, middle);
        } else if (queryL <= middle) {
            return query(right(treeIndex), queryL, queryR, middle + 1, end);
        } else {
            int left = query(left(treeIndex), queryL, middle, start, middle);
            int right = query(right(treeIndex), middle + 1, queryR, middle + 1, end);
            return left + right;
        }
    }

    public int left(int i) {
        return i * 2 + 1;
    }

    public int right(int i) {
        return i * 2 + 2;
    }
}

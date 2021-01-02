package one;

import java.util.Arrays;

/**
 * @author huanghaoxing
 */
public class SegmentTree {

  private int[] data;
  private int[] tree;

  public SegmentTree(int[] arr) {
    this.data = arr;
    tree = new int[4 * arr.length];
    buildSegmentTree(0, 0, arr.length - 1);
  }

  // [l .. r]
  private void buildSegmentTree(int treeIndex, int l, int r) {
    if (l == r) {
      tree[treeIndex] = data[l];
      return;
    }
    int mid = l + (r - l) / 2;
    int leftIndex = leftChild(treeIndex);
    int rightIndex = rightChild(treeIndex);

    buildSegmentTree(leftIndex, l, mid);
    buildSegmentTree(rightIndex, mid + 1, r);
    tree[treeIndex] = tree[leftIndex] + tree[rightIndex];

  }

  private int leftChild(int index) {
    return index * 2 + 1;
  }

  private int rightChild(int index) {
    return index * 2 + 2;
  }

  // [queryL ..query]
  public int query(int queryL, int queryR) {
    return query(0, 0, data.length - 1, queryL, queryR);
  }

  // [l .. r]
  private int query(int treeIndex, int l, int r, int queryL, int queryR) {
    if (l == queryL && r == queryR) {
      return tree[treeIndex];
    }
    int mid = l + (r - l) / 2;
    // [l ...mid] , [mid +1 ,r]
    int rightIndex = rightChild(treeIndex);
    int leftIndex = leftChild(treeIndex);

    if (mid < queryL) {
      return query(rightIndex, mid + 1, r, queryL, queryR);
    } else if (queryR <= mid) {
      return query(leftIndex, l, mid, queryL, queryR);
    } else {
      return query(leftIndex, l, mid, queryL, mid) + query(rightIndex, mid + 1, r, mid + 1, queryR);
    }
  }


  public void set(int index, int e) {

  }

  private void set(int treeIndex, int l, int r, int index, int e) {
    if (l == r) {
      tree[treeIndex] = e;
      return;
    }

    int mid = l + (r - l) / 2;
    int leftChild = leftChild(treeIndex);
    int rightChild = rightChild(treeIndex);
    if (mid < index) {
      set(rightChild, mid + 1, r, index, e);
    } else {
      set(leftChild, l, mid, index, e);
    }
    tree[treeIndex] = tree[rightChild] + tree[leftChild];
  }

  public static void main(String[] args) {
    SegmentTree segmentTree = new SegmentTree(new int[]{0, 1, 2, 3, 4, 5});
    System.out.println(Arrays.toString(segmentTree.tree));
    System.out.println(segmentTree.query(1, 1));

  }


}

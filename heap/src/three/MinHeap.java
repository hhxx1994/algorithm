package three;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class MinHeap {
    List<Integer> arr = new ArrayList<>();

    public MinHeap(int[] arr) {
        for (int i : arr) {
            this.arr.add(i);
        }
        int parent = parent(this.arr.size());
        for (int i = parent; i >= 0; i--) {
            siftDown(i);
        }
    }

    private void siftDown(int i) {
        int j = left(i);
        if (j >= arr.size()) {
            return;
        }
        if (j + 1 < arr.size() && arr.get(j + 1) < arr.get(j)) {
            j++;
        }
        if (arr.get(j) < arr.get(i)) {
            swap(i, j);
            siftDown(j);
        }
    }

    public void add(int i) {
        arr.add(i);
        siftUp(arr.size() - 1);
    }

    public int remove() {
        int head = arr.get(0);
        swap(0, arr.size() - 1);
        arr.remove(arr.size() - 1);
        siftDown(0);
        return head;
    }

    private void siftUp(int i) {
        int parent = parent(i);
        if (parent < 0) {
            return;
        }
        if (arr.get(i) < arr.get(parent)) {
            swap(i, parent);
            siftUp(parent);
        }

    }

    private void swap(int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private int left(int i) {
        return i * 2 + 1;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

}

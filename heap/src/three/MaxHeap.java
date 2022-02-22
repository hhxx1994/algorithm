package three;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class MaxHeap {
    private List<Integer> arr = new ArrayList<>();

    public void add(Integer val) {
        arr.add(val);
        shifUp(arr.size() - 1);
    }

    public int remove() {
        int head = arr.get(0);
        swap(0, arr.size() - 1);
        arr.remove(arr.size() - 1);
        shifDown(0);

        return head;
    }

    private void shifDown(int index) {
        int leftIndex = leftChild(index);
        if (leftIndex > arr.size()) {
            return;
        }
        if (leftIndex + 1 < arr.size() && arr.get(leftIndex) < arr.get(leftIndex + 1)) {
            leftIndex++;
        }
        if (arr.get(leftIndex) > arr.get(index)) {
            swap(leftIndex, index);
            shifDown(leftIndex);
        }

    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return (index + 1) * 2;
    }

    private void shifUp(int index) {
        int parentIndex = parent(index);
        if (parentIndex < 0) {
            return;
        }
        if (arr.get(index) > arr.get(parentIndex)) {
            swap(index, parentIndex);
            shifUp(parentIndex);
        }
    }


    private void swap(int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }
}

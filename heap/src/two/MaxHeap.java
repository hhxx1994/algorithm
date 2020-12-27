package two;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class MaxHeap {

    List<Integer> arr = new ArrayList<>();

    public void add(int data) {
        arr.add(data);
        int index = arr.size() - 1;

        while (true) {
            int parentIndex = parentIndex(index);
            if (parentIndex > 0) {
                int parent = arr.get(parentIndex);
                if (parent < data) {
                    arr.set(parentIndex, data);
                    arr.set(index, parent);
                    index = parentIndex;
                    continue;
                }
            }
            break;
        }
    }

    private void siftUp(int index) {
        int parentIndex = parentIndex(index);
        int parent = arr.get(parentIndex);
        int data = arr.get(index);
        if (parent > data) {
            return;
        }
        arr.set(parentIndex, data);
        arr.set(index, parent);

        siftUp(parentIndex);
    }


    private void siftUp01(int index) {
        // 上浮的条件
        while (index > 0 && arr.get(parentIndex(index)) < arr.get(index)) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }


    public int remove() {
        Integer ret = arr.get(0);
        swap(0, arr.size() - 1);
        siftDown(0);
        return ret;
    }

    private void siftDown(int index) {
        // 下沉的条件
        while (leftIndex(index) < arr.size()) {
            int leftIndex = leftIndex(index);
            int maxIndex = leftIndex;
            if (rightIndex(index) < arr.size() && arr.get(leftIndex) < arr.get(rightIndex(index))) {
                maxIndex = rightIndex(index);
            }

            if (arr.get(index) > arr.get(maxIndex)) {
                break;
            }

            swap(index, maxIndex);
            index = maxIndex;
        }

    }

    private void swap(int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftIndex(int index) {
        return index * 2 + 1;
    }

    private int rightIndex(int index) {
        return index * 2 + 2;
    }

}

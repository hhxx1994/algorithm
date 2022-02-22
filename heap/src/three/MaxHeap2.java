package three;

/**
 * @author huanghaoxing
 */
public class MaxHeap2 {
    int[] arr;
    int size;

    public MaxHeap2(int[] arr) {
        this.arr = arr;
        int parent = parent(arr.length - 1);
        for (int i = parent; i >= 0; i--) {
            siftDown(i);
        }
    }

    public void add(int val) {
        arr[size] = val;
        siftUp(size);
        size++;
    }

    public int remove() {
        int head = arr[0];
        arr[0] = arr[size - 1];
        size--;
        siftDown(0);
        return head;
    }

    private void siftDown(int index) {
        int j = leftChild(index);
        if (j >= size) {
            return;
        }
        if (j + 1 < size && arr[j + 1] > arr[j]) {
            j++;
        }
        if (arr[j] > arr[index]) {
            swap(j, index);
            siftDown(j);
        }
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private void siftUp(int index) {
        int parent = parent(index);
        if (parent < 0) {
            return;
        }
        if (arr[parent] < arr[index]) {
            swap(parent, index);
            siftUp(parent);
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }
}

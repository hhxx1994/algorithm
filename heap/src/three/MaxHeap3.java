package three;

/**
 * @author huanghaoxing
 */
public class MaxHeap3 {

    int[] arr;

    public MaxHeap3(int[] arr) {
        this.arr = arr;
        int parent = parent(arr.length - 1);
        for (int i = parent; i >= 0; i--) {
            siftDown(i);
        }
    }

    private void siftDown(int index) {
        int i = leftChild(index);
        if (i >= arr.length) {
            return;
        }
        if (i + 1 < arr.length && arr[i] < arr[i + 1]) {
            i++;
        }
        if (arr[i] > arr[index]) {
            swap(i, index);
            siftDown(i);
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }


    public int parent(int index) {
        return (index - 1) / 2;
    }

}

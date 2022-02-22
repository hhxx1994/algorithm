package three;

/**
 * @author huanghaoxing
 */
public class QuickSort2 {

    public int[] sort(int[] arr) {
        sort(arr, 0, arr.length);
        return arr;
    }

    // arr[start,end)
    private void sort(int[] arr, int start, int end) {
        if (start >= end - 1) {
            return;
        }
        int p = partition(arr, start, end);
        sort(arr, start, p - 1);
        sort(arr, p + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        int j = end - 1;
        while (true) {
            while (i <= j && arr[i] < pivot) {
                i++;
            }
            while (i <= j && pivot < arr[j]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, start, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

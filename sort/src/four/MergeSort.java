package four;

/**
 * @author huanghaoxing
 */
public class MergeSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    // arr[start,end)
    public void sort(int[] arr, int start, int end) {
        if (start >= end - 1) {
            return;
        }

        int middle = start + (end - start) / 2;
        sort(arr, start, middle);
        sort(arr, middle, end);
        merge(arr, start, middle, end);

    }

    private void merge(int[] arr, int start, int middle, int end) {
        int[] newarr = new int[end - start];
        int i = start;
        int j = middle;
        for (int k = 0; k < newarr.length; k++) {
            if (i > middle) {
                arr[k] = arr[j];
                j++;
            } else if (j > end) {
                arr[k] = arr[j];
                i++;
            } else if (arr[i] < arr[j]) {
                newarr[k] = arr[i];
                i++;
            } else {
                newarr[k] = arr[j];
                j++;
            }
        }
        System.arraycopy(newarr, 0, arr, start, newarr.length);

    }
}

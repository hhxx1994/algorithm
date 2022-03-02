package five;

/**
 * @author huanghaoxing
 */
public class MergeSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    // [start,end]
    public void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = start + (end - start) / 2;
        sort(arr, start, middle);
        sort(arr, middle + 1, end);
        merge(arr, start, middle, end);
    }

    private void merge(int[] arr, int start, int middle, int end) {
        int[] newarr = new int[end - start + 1];
        int i = start;
        int j = middle + 1;
        for (int k = 0; k < newarr.length; k++) {

            if (i > middle) {
                arr[k] = arr[j];
                j++;
            } else if (j > end) {
                arr[k] = arr[i];
                i++;
            } else if (arr[i] < arr[j]) {
                arr[k] = arr[i];
                i++;
            } else {
                arr[k] = arr[j];
                j++;
            }

        }

    }

}

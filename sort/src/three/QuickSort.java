package three;

/**
 * @author huanghaoxing
 */
public class QuickSort {

    public int[] sort(int[] arr) {
        sort(arr, 0, arr.length);
        return arr;
    }

    // [start,end)
    public void sort(int[] arr, int start, int end) {
        if (start >= end - 1) {
            return;
        }

        int pivot = partition(arr, start, end);
        sort(arr, start, pivot);
        sort(arr, pivot + 1, end);
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


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] ints = {5, 1, 1, 2, 0, 0};
        int[] sort = quickSort.sort(ints);
        for (int i : sort) {
            System.out.print(i);
            System.out.print(" ");
        }
    }


}

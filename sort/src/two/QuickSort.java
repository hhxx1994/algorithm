package two;

import java.util.Random;

/**
 * @author huanghaoxing
 */
public class QuickSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    // sort arr[l,r]
    public void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);

    }

    private int partition(int[] arr, int l, int r) {
        int randomIndex = new Random().nextInt(r - l + 1) + l;
        swap(arr, l, randomIndex);

        int pivot = arr[l];
        int j = l;
        // arr[l+1,j] < pivot  <= arr[j+1,i] , 先抽象在临界考虑
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < pivot) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {7,2,5,6,9,7,3,5,90,0,2};
        quickSort.sort(arr);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
    }


}

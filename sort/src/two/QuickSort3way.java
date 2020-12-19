package two;

import java.util.Random;

/**
 * @author huanghaoxing
 */
public class QuickSort3way {

    public void sort(int[] arr) {
        partition(arr, 0, arr.length - 1);
    }

    private void partition(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int randomIndex = new Random().nextInt(r - l + 1) + l;
        System.out.println(randomIndex);
        swap(arr, l, randomIndex);

        int pivot = arr[l];

        // [l+1,lt] < pivot  [lt+1,i-1] == pivot pivot < [gt,r]
        int lt = l;
        int gt = r + 1;

        for (int i = l + 1; i < gt; i++) {
            if (arr[i] < pivot) {
                lt++;
                swap(arr, lt, i);
            } else if (pivot < arr[i]) {
                gt--;
                swap(arr, gt, i);
            }
        }
        swap(arr, l, lt);
        // arr[l,p-1] p arr[p+1,r]
        partition(arr, l, lt - 1);
        partition(arr, gt, r);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort3way quickSort3way = new QuickSort3way();
        int[] arr = {7, 2, 5};
        quickSort3way.sort(arr);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
    }
}

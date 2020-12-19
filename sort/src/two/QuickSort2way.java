package two;

import java.util.Random;

/**
 * @author huanghaoxing
 */
public class QuickSort2way {


    public void sort(int[] arr) {

    }

    // arr[l,r]
    public void sort(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        // arr[l,p-1]  p arr[p+1,r]
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);

    }

    private int partition(int[] arr, int l, int r) {
        int randomIndex = new Random().nextInt(r - l + 1) + l;
        swap(arr, randomIndex, l);

        int pivot = arr[l];

        // arr[l+1,lt] <= pivot   arr[gt,r] >= pivot , lt = l+1 , gt = r
        int lt = l + 1;
        int gt = r;
        while (true) {

            while (lt <= r && arr[lt] < pivot) {
                lt++;
            }

            while (gt >= l + 1 && arr[gt] > pivot) {
                gt--;
            }

            if (gt < lt) {
                break;
            }

            swap(arr, gt, lt);
            lt++;
            gt--;

        }
        swap(arr, gt, l);

        return gt;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

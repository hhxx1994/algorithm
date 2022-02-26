package four;

import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class SelectSort {

    public void sort(int[] arr) {

        for (int k = 0; k < arr.length; k++) {

            // arr[0,i) 有序 arr[i,end) 无序
            int minIndex = k;
            for (int i = k; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }
            swap(arr, minIndex, k);
        }

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

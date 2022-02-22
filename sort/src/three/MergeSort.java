package three;

import java.util.Arrays;
import java.util.Random;

/**
 * @author huanghaoxing
 */
public class MergeSort {

    public int[] sort(int[] arr) {

        sort(arr, 0, arr.length);
        return arr;
    }

    // [start,end)
    private void sort(int[] arr, int start, int end) {
        if (start >= end - 1) {
            return;
        }
        int middle = start + (end - start) / 2;
        sort(arr, start, middle);
        sort(arr, middle, end);
        merge(arr, start, middle, end);
    }

    // 二路归并 [start,middle) [middle,end)
    private void merge(int[] arr, int start, int middle, int end) {
        int[] newarr = new int[end - start];

        int i = start;
        int j = middle;
        for (int k = 0; k < newarr.length; k++) {
            if (i == middle) {
                newarr[k] = arr[j];
                j++;
            } else if (j == end) {
                newarr[k] = arr[i];
                i++;
            } else if (arr[i] < arr[j]) {
                newarr[k] = arr[i];
                i++;
            } else {
                newarr[k] = arr[j];
                j++;
            }

        }

        System.arraycopy(newarr,0,arr,start,newarr.length);
//        for (int k = 0; k < newarr.length; k++) {
//            arr[start] = newarr[k];
//            start++;
//        }

    }

    // 生成一个长度为 n 的随机数组，每个数字的范围是 [0, bound)
    public static int[] generateRandomArray(int n, int bound) {

        int[] arr = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++)
            arr[i] = rnd.nextInt(bound);
        return arr;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = {8, 8, 3, 7, 9, 9, 9, 9, 8, 4};
        mergeSort.sort(array);
        System.out.println(Arrays.toString(array));

//        int[] ints = {7, 8, 8, 3, 8, 9, 9, 4, 8, 4};
//        mergeSort.merge(ints, 8, 9, 10);
    }
}

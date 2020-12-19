package two;

import java.util.Arrays;

/**
 * @author huanghaoxing
 */
public class MergeSort {

    public int[] mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    // 处理arr[l,r]
    public void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    // 归并 arr[l,mid] arr[mid+1,r]
    private void merge(int[] arr, int l, int mid, int r) {
        // 偏移量为l
        int[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int j = l;
        int k = mid + 1;
        for (int i = l; i <= r; i++) {

            if (j > mid) {
                arr[i] = temp[k - l];
                k++;
            } else if (k > r) {
                arr[i] = temp[j - l];
                j++;
            } else if (temp[j - l] < temp[k - l]) {
                arr[i] = temp[j - l];
                j++;
            } else {
                arr[i] = temp[k - l];
                k++;
            }

        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] sort = mergeSort.mergeSort(new int[]{2, 5, 7, 9, 6, 3, 1, 3, 5, 6, 7, 9, 6, 5, 3, 2, 4, 65, 8,});
        for (int i : sort) {
            System.out.print(i);
            System.out.print(",");
        }
    }

}

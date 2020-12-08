package one;

import java.util.Arrays;

/**
 * @author huanghaoxing
 */
public class MergeSort {
  // arr[l...r]
  private static void sort(int[] arr, int l, int r) {
    if (l >= r) {
      return;
    }
    int mid = l + (r - l) / 2;
    // arr[l ... mid]
    sort(arr, l, mid);
    // arr[mid+1 ... r]
    sort(arr, mid + 1, r);
    // 如果 arr[mid] < arr[mid+1] arr[l ...r] 本身有序
    if (arr[mid] > arr[mid + 1]) {
      merge(arr, l, mid, r);
    }

  }

  // merge arr[l .. mid]  arr[mid +1 ...r ]
  private static void merge(int[] arr, int l, int mid, int r) {
    int[] temp = Arrays.copyOfRange(arr, l, r + 1);
    int j = mid + 1;
    int i = l;
    int q = l;
    while (l <= mid && j <= r) {
      if (temp[l - q] < temp[j - q]) {
        arr[i] = temp[l - q];
        i++;
        l++;
      } else {
        arr[i] = temp[j - q];
        j++;
        i++;
      }
    }

    if (j <= r) { // temp[l ... mid] 比较完毕 , temp[j...r] 全部加进去
      for (int k = j; k <= r; k++) {
        arr[i] = temp[k - q];
        i++;
      }
    }

    if (l <= mid) {// temp[j ... r] 比较完毕 , temp[l...mid] 全部加进去
      for (int k = l; k <= mid; k++) {
        arr[i] = temp[k - q];
        i++;
      }
    }
  }

  public static void sort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }
    sort(arr, 0, arr.length - 1);
  }

  public static void main(String[] args) {
    int[] arr = {3, 6, 1, 7, 3, 2, 5, 8, 0, 3, 4, 8};
    sort(arr);
    for (int i : arr) {
      System.out.print(i);
      System.out.print(",");
    }
  }

}

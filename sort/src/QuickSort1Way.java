/**
 * @author huanghaoxing 快排
 */
public class QuickSort1Way {

  // [l...r) 排序
  private static void sort(int[] arr, int l, int r) {
    if (l >= r - 1) {
      return;
    }

    int p = partition(arr, l, r);
    sort(arr, l, p);
    sort(arr, p + 1, r);
  }

  // arr[l ... r)  partition  arr[l + 1 ... p) <  pivot   arr[p+1 .... r) > pivote
  private static int partition(int[] arr, int l, int r) {
    int pivot = arr[l];
    int k = l;
    for (int i = l; i < r; i++) {
      if (arr[i] < pivot) {
        k++;
        swap(arr, k, i);
      }
    }
    swap(arr, l, k);
    return k;
  }

  private static void swap(int[] arr, int k, int i) {
    int temp = arr[k];
    arr[k] = arr[i];
    arr[i] = temp;
  }

  public static void sort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }
    sort(arr, 0, arr.length);
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

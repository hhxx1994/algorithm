import java.util.Random;

/**
 * @author huanghaoxing 随机化标定点 , 主要解决几乎有序的序列 , 避免partiton不均匀导致算法退化成O(n^2)
 */
public class RandomPivotQuickSort1Way {

  // [l ... r]
  private static void sort(int[] arr, int l, int r) {

    if (l >= r) {
      return;
    }

    int randomIndex = new Random().nextInt(r - l + 1) + l;
    swap(arr, randomIndex, l);
    // partition [l...r]
    int p = partition(arr, l, r);
    sort(arr, l, p - 1);
    sort(arr, p + 1, r);
  }

  // arr[l+1 ... p -1] < pivot      arr[p+1 ... r] > pivote
  private static int partition(int[] arr, int l, int r) {
    int pivot = arr[l];
    int k = l + 1;
    for (int i = l + 1; i <= r; i++) {
      if (arr[i] < pivot) {
        if (i != k) {
          swap(arr, k, i);
        }
        k++;
      }
    }
    swap(arr, l, k - 1);
    return k - 1;
  }


  private static void swap(int[] arr, int k, int i) {
    int temp = arr[i];
    arr[i] = arr[k];
    arr[k] = temp;
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

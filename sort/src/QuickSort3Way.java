/**
 * @author huanghaoxing 三路快排
 */
public class QuickSort3Way {

  // arr[l ... r]  排序
  private static void sort(int[] arr, int l, int r) {
    if (l >= r) {
      return;
    }
    int pivot = arr[l];
    int lt = l; // arr[l+1 .. lt] < v
    int gt = r + 1;  // arr[gt ... r] > v
    int i = l + 1;   // arr[lt + 1 ... i) == v
    while (i < gt) {
      if (arr[i] < pivot) {
        swap(arr, lt + 1, i);
        lt++;
        i++;
      } else if (arr[i] > pivot) {
        swap(arr, gt - 1, i);
        gt--;
      } else {
        i++;
      }
    }
    swap(arr, l, lt);

    sort(arr, l, lt - 1);
    sort(arr, gt, r);
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
    int[] arr = {4, 3, 2, 1};
    sort(arr);
    for (int i : arr) {
      System.out.print(i);
      System.out.print(",");
    }
  }

}

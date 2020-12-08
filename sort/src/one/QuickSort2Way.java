package one;

/**
 * @author huanghaoxing 二路快排
 */
public class QuickSort2Way {

  // [l ... r]
  private static void sort(int[] arr, int l, int r) {
    if (l >= r) {
      return;
    }

    int p = partition(arr, l, r);
    sort(arr, l, p - 1);
    sort(arr, p + 1, r);
  }

  // arr[l+1....p) <= pivot      arr[p+1 .... r] >= pivot
  private static int partition(int[] arr, int l, int r) {
    //int randomIndex = new Random().nextInt(r - l + 1) + l;
    //swap(arr, l, randomIndex);

    int pivot = arr[l];
    int lt = l + 1;
    int gt = r;
    while (true) {
      while (lt <= r && arr[lt] < pivot) lt++;
      while (l + 1 <= gt && pivot < arr[gt]) gt--;
      if (lt > gt) {
        break;
      }
      swap(arr, lt, gt);
      lt++;
      gt--;
    }
    swap(arr, gt, l);
    return gt;
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
    int[] arr = {7, 3, 6, 1};
    sort(arr);
    for (int i : arr) {
      System.out.print(i);
      System.out.print(",");
    }
  }
}

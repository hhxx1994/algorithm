/**
 * @author huanghaoxing
 */
public class SelectionSort {

  public static void sort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }
    int minIndex;
    for (int i = 0; i < arr.length; i++) {
      minIndex = i;
      for (int j = i; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      swap(arr, i, minIndex);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 5, 7, 3, 7, 8};
    sort(arr);
    for (int i : arr) {
      System.out.print(i);
      System.out.print(",");
    }
  }
}

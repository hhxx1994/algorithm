/**
 * @author huanghaoxing
 */
public class InsertionSort {

  public static void sort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }

    int length = arr.length;
    for (int i = 0; i < length; i++) { // i 代表待排序的index
      int e = arr[i];
      int j = i;
      for (; j > 0 && arr[j - 1] > e; j--) {
        arr[j] = arr[j - 1];
      }
      arr[j] = e;
    }
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

/**
 * @author huanghaoxing
 */
public class SelectionSort2 {

  public static void sort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }
    // arr[0,i] 未排序  arr(i , n) 已排序
    for (int i = arr.length - 1; 0 <= i; i--) {

      // 寻找arr[0,i] 中的最大值
      int maxIndex = 0;
      for (int j = 0; j <= i; j++) {
        if (arr[j] > arr[maxIndex]) {
          maxIndex = j;
        }
      }
      swap(arr, maxIndex, i);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 5, 7, 3, 7, 8, 3, 4, 1, 7, 3, 4};
    sort(arr);
    for (int i : arr) {
      System.out.print(i);
      System.out.print(" ");
    }
  }


}

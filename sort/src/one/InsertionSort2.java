package one;

/**
 * @author huanghaoxing
 */
public class InsertionSort2 {

  public static void sort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }
    // arr[0,i) 有序 , 从arr[i] 中插入到arr[0,i)
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; 0 < j; j--) {
        if (arr[j] < arr[j - 1]) {
          swap(arr, j, j - 1);
        } else {
          break;
        }
      }
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

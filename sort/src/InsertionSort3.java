/**
 * @author huanghaoxing
 */
public class InsertionSort3 {

  public static void sort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }
    // arr[0,i) 已排序
    for (int i = 0; i < arr.length; i++) {
      int e = arr[i];
      int index = find(arr, 0, i - 1, arr[i]);
      // [index ... i-1] 移动到 [index + 1 .... i]
      for (int j = i; j > index; j--) {
        arr[j] = arr[j - 1];
      }
      arr[index] = e;
    }
  }

  // arr[i,j] 查找target
  public static int find(int[] arr, int i, int j, int target) {
    if (i > j) {
      return i;
    }
    int mid = i + (j - i) / 2;
    if (arr[mid] == target) {
      return mid;
    } else if (target < arr[mid]) {
      j = mid - 1;
    } else {
      i = mid + 1;
    }
    return find(arr, i, j, target);
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

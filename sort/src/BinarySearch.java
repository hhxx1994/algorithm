/**
 * @author huanghaoxing
 */
public class BinarySearch {
  public static int search(int[] arr, int target) {
    if (arr == null || arr.length == 0) {
      return -1;
    }
    // [left ... right]
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  public static int insertIndex(int[] arr, int target) {
    if (arr == null || arr.length == 0) {
      return -1;
    }
    return find(arr, 0, arr.length - 1, target);

  }

  // [left .. right]
  public static int find(int[] arr, int left, int right, int target) {
    if (left > right) {
      return left;
    }
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) {
      return mid;
    } else if (arr[mid] < target) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
    return find(arr, left, right, target);
  }


}

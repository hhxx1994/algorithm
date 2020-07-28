import java.util.Random;

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
    int length = 300000;
    int[] arr = new int[length];
    for (int i = 0; i < length; i++) {
      arr[i] = new Random().nextInt(length);
    }
    long start = System.currentTimeMillis();
    InsertionSort.sort(arr);
    long end = System.currentTimeMillis();
    System.out.println(end - start);

    for (int i = 0; i < length; i++) {
      arr[i] = new Random().nextInt(length);
    }

    start = System.currentTimeMillis();
    InsertionSort3.sort(arr);
    end = System.currentTimeMillis();
    System.out.println(end - start);
  }

}

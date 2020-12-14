package two;

/**
 * @author huanghaoxing
 */
public class InsertSort {

    public int[] insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            // arr[0,i) 排序 arr[i,n) 未排序
            int e = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1]/**前一个*/ > e; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] ret = insertSort.insertSort(new int[]{3, 5, 1, 6, 8, 4,});
        for (int i : ret) {
            System.out.println(i);
        }
    }

}

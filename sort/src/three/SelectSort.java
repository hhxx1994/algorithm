package three;

/**
 * @author huanghaoxing
 */
public class SelectSort {

    public int[] selectSort(int[] arr) {

        for (int j = 0; j < arr.length; j++) {
            // arr[0,i) 已排序 arr[i,n) 未排序
            int minIndex = j;
            for (int i = j; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }
            swap(arr, j, minIndex);
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

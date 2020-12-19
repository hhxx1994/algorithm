package two;

/**
 * @author huanghaoxing
 * 自底向上归并
 */
public class MergeSort3 {

    public void mergeSort(int[] arr) {
        int length = arr.length;
        int[] temp = new int[length];
        for (int zs = 1; zs <= arr.length; zs += zs) {
            // arr[i,i + zs -1 ]  arr[i + zs, i + zs +zs -1] 归并
            for (int i = 0; i + zs + 1 <= length; i += zs + zs) {
                merge(arr, i, i + zs - 1, Math.min(length - 1, i + zs + zs - 1), temp);
            }
        }
    }

    private void merge(int[] arr, int l, int mid, int r, int[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);

        int tl = l;
        int tm = mid + 1;

        for (int i = l; i <= r; i++) {
            if (tl > mid) {
                arr[i] = temp[tm];
                tm++;
            } else if (tm > r) {
                arr[i] = temp[tl];
                tl++;
            } else if (temp[tl] < temp[tm]) {
                arr[i] = temp[tl];
                tl++;
            } else {
                arr[i] = temp[tm];
                tm++;
            }
        }
    }

    public static void main(String[] args) {
        MergeSort3 mergeSort = new MergeSort3();
        int[] arr = {2, 5, 7, 9, 6, 3, 1, 3, 5, 6, 7, 9, 6, 5, 3, 2, 4, 65, 8,};
        mergeSort.mergeSort(arr);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
    }
}

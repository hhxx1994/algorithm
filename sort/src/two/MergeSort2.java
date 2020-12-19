package two;

/**
 * @author huanghaoxing
 */
public class MergeSort2 {


    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }


    // sort arr[l,r]
    public void sort(int[] arr, int l, int r, int[] temp) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        merge(arr, l, mid, r, temp);
    }

    // merge arr[l,mid] arr [mid+1,r]
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
        MergeSort2 mergeSort2 = new MergeSort2();
        int[] arr = {1, 4, 6, 8, 0, 9, 7, 5, 3, 2, 4, 6, 8, 4};
        mergeSort2.mergeSort(arr);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
    }

}

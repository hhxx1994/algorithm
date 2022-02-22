package three;

/**
 * @author huanghaoxing
 */
public class InsertSort {

    public int[] sort(int[] arr) {

        for (int j = 1; j < arr.length; j++) {
            // arr[0,i) 有序 arr[i,n) 无序
            int cur = arr[j];
            int insertIndex = -1;
            for (int i = j - 1; i >= 0; i--) {
                if (cur < arr[i]) {
                    insertIndex = i;
                    arr[i + 1] = arr[i];
                }
            }
            if (insertIndex != -1) {
                arr[insertIndex] = cur;
            }
        }

        return arr;

    }
}

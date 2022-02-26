package four;

/**
 * @author huanghaoxing
 */
public class InsertSort {

    public void sort(int[] arr) {

        for (int k = 0; k < arr.length; k++) {
            // arr[0,i) arr[i,end)
            int j = arr[k];
            int index = k;
            for (int i = k; i > 0; i--) {
                if (arr[i] < j) {
                    arr[i] = arr[i - 1];
                    index = i - 1;
                }
            }
            arr[index] = j;
        }

    }

}

package two;

import java.util.Random;

/**
 * @author huanghaoxing
 */
public class SelectK {


    public int selectK(int[] array, int k) {
        return partition(array, 0, array.length - 1, k);
    }


    // arr[l,r]
    private int partition(int[] array, int l, int r, int k) {
        int randomIndex = new Random().nextInt(r - l + 1) + l;
        swap(array, randomIndex, l);
        int pivot = array[l];
        int j = l;
        // arr[l+1, j] < pivot  <= [j+1 ,r]
        for (int i = l + 1; i <= r; i++) {
            if (array[i] < pivot) {
                j++;
                swap(array, j, i);
            }
        }
        swap(array, j, l);

        if (j == k) {
            return array[j];
        } else if (j < k) {
            return partition(array, j + 1, r, k);
        } else {
            return partition(array, l, j - 1, k);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        SelectK selectK = new SelectK();
        int[] array = {2, 4, 6, 7, 8, 9, 7, 5, 3, 1, 4, 5, 7, 8, 0};
        for (int i = 0; i < array.length; i++) {
            System.out.print(selectK.selectK(array, i));
            System.out.print(",");
        }

    }


}

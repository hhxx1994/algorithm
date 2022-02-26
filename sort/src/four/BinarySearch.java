package four;

/**
 * @author huanghaoxing
 */
public class BinarySearch {


    public int search(int[] arr, int target) {

        return search(arr, 0, arr.length, target);
    }

    private int search(int[] arr, int start, int end, int target) {
        if (start > end - 1) {
            return -1;
        }
        int middle = start + (end - start) / 2;
        if (arr[middle] == target) {
            return middle;
        }
        if (arr[middle] < target) {
            return search(arr, middle + 1, end, target);
        } else {
            return search(arr, start, middle - 1, target);
        }
    }
}

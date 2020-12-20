package two;

/**
 * @author huanghaoxing
 */
public class BinarySearch {

    public int search(int[] arr, int target) {

        int l = 0;
        int r = arr.length - 1;
        // arr[l,r]
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1; // arr[mid+1,r]
            } else {
                r = mid - 1; // arr[l,mid-1]
            }
        }
        return -1;
    }


    public int search(int[] arr, int l, int r, int target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return search(arr, mid + 1, r, target);
        } else {
            return search(arr, l, mid - 1, target);
        }
    }


}

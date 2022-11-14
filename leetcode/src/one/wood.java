package one;

/**
 * @author huanghaoxing
 * 切割木头
 */
public class wood {

    public int wood(int n, int k, int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (max < j) {
                max = j;
            }
        }
        int l = 1;
        int r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(n, k, arr, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private boolean check(int n, int k, int[] arr, int length) {
        int ret = 0;
        for (int arrLength : arr) {
            ret += arrLength / length;
        }
        return ret > k;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 2, 10, 5};
        System.out.println(new wood().wood(5, 5, arr));
    }
}

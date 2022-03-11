/**
 * @author huanghaoxing
 */
public class GetModifiedArray {

    int[] getModifiedArray(int length, int[][] updates) {
        int[] ret = new int[length];
        int[] diff = new int[length];
        for (int[] update : updates) {
            int l = update[0];
            int r = update[1];
            int change = update[2];
            diff[l] += change;
            if (r + 1 < length) {
                diff[r + 1] -= change;
            }
        }

        ret[0] = diff[0];
        for (int i = 1; i < length; i++) {
            ret[i] = ret[i - 1] + diff[i];
        }
        return ret;
    }
}

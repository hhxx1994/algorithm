package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class merge56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ret = new ArrayList<>();
        ret.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] n1 = ret.get(ret.size() - 1);
            int[] n2 = intervals[i];
            if (n1[1] < n2[0]) {
                ret.add(n2);
            } else if (n1[1] <= n2[1]) {
                n1[1] = n2[1];
            }
        }

        return ret.toArray(new int[ret.size()][]);
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 4}, {1, 4}};
        new merge56().merge(ints);
    }
}

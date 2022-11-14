package one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class spiralOrder54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int R = matrix.length;
        int C = matrix[0].length;
        int r = 0;
        int c = 0;
        int dir = 0;
        boolean[][] visited = new boolean[R][C];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < R * C; i++) {
            ret.add(matrix[r][c]);
            visited[r][c] = true;
            int nextr = r + dirs[dir][0];
            int nextc = c + dirs[dir][1];
            if (nextr < 0 || nextr >= R || nextc < 0 || nextc >= C || visited[nextr][nextc]) {
                dir = (dir + 1) % 4;
            }

            r = r + dirs[dir][0];
            c = c + dirs[dir][1];
        }
        return ret;
    }
}

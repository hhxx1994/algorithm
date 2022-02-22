package graph2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class Solution4 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 1) {
            return 1;
        }

        if (grid[0][0] != 0) {
            return -1;
        }

        int R = grid.length;
        int C = grid[0].length;
        int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        boolean[][] visited = new boolean[R][C];
        int[][] dirs = new int[R][C];
        Arrays.fill(dirs, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0][0] = true;
        dirs[0][0] = 1;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            int r = v / C;
            int c = v % C;
            for (int i = 0; i < d.length; i++) {
                int nextr = r + d[i][0];
                int nextc = c + d[i][1];
                if (nextc >= 0 && nextc < C && nextr >= 0 && nextr < R && !visited[nextr][nextc] && grid[nextr][nextc] == 0) {
                    visited[nextr][nextc] = true;
                    queue.add(nextr * C + nextc);
                    dirs[nextr][nextc] = dirs[r][c] + 1;
                    if (nextc == C - 1 && nextr == R - 1) {
                        return dirs[nextr][nextc];
                    }
                }
            }

        }

        return -1;
    }
}

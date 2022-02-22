package graph2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class Solution3 {

    boolean[] visited;
    int R;
    int C;
    int[][] grid;
    int[] dir;

    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid.length == 1){
            return 1;
        }

        if (grid[0][0] != 0) {
            return -1;
        }

        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        visited = new boolean[R * C];
        dir = new int[R * C];
        Arrays.fill(dir, -1);
        return bfs();
    }

    private int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        dir[0] = 1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};
        while (!queue.isEmpty()) {
            int v = queue.remove();
            int r = v / C;
            int c = v % C;
            for (int i = 0; i < dirs.length; i++) {
                int nextr = r + dirs[i][0];
                int nextc = c + dirs[i][1];
                if (nextc >= 0 && nextc < C && nextr >= 0 && nextr < R && !visited[nextr * R + nextc] && grid[nextr][nextc] == 0) {
                    visited[nextr * R + nextc] = true;
                    queue.add(nextr * R + nextc);
                    dir[nextr * R + nextc] = dir[v] + 1;
                    if (nextr == R - 1 && nextc == C - 1) {
                        return dir[nextr * R + nextc];
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[][] c = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int ret = solution3.shortestPathBinaryMatrix(c);
        System.out.println(ret);
    }
}

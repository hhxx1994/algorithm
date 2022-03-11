/**
 * @author huanghaoxing
 */
public class GenerateMatrix59 {


    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int r = 0;
        int c = 0;
        int dir = 0;
        for (int i = 0; i < n * n; i++) {
            visited[r][c] = true;
            ret[r][c] = i + 1;
            int nextr = r + dirs[dir][0];
            int nextc = c + dirs[dir][1];

            if (nextc < 0 || nextc >= n || nextr < 0 || nextr >= n || visited[nextr][nextc]) {
                dir = (dir + 1) % 4;
            }
            r = r + dirs[dir][0];
            c = c + dirs[dir][1];
        }
        return ret;
    }
}

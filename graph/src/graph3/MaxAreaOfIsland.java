package graph3;

/**
 * @author huanghaoxing
 */
public class MaxAreaOfIsland {

    int[][] grid;
    boolean[][] visited;
    int R;
    int C;
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ret = 0;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ret = Math.max(dfs(i, j), ret);
                }
            }
        }
        return ret;
    }

    private int dfs(int r, int c) {
        visited[r][c] = true;
        int ret = 1;
        for (int i = 0; i < dir.length; i++) {
            int nextr = r + dir[i][0];
            int nextc = c + dir[i][1];
            if (nextr >= 0 && nextr < R && nextc >= 0 && nextc < C && grid[nextr][nextc] == 1 && !visited[nextr][nextc]) {
                ret += dfs(nextr, nextc);
            }
        }
        return ret;
    }
}

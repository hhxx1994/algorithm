package graph2;

/**
 * @author huanghaoxing
 */
public class Solution2 {

    boolean[][] visited;
    int R;
    int C;

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        int ret = 0;
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
        for (int i = 0; i < dirs.length; i++) {
            int nextr = r + dirs[i][0];
            int nextc = c + dirs[i][1];
            if (nextr >= 0 && nextr < R && nextc >= 0 && nextc < C && !visited[nextr][nextc] && grid[nextr][nextc] == 1) {
                ret += dfs(nextr, nextc);
            }
        }

        return ret;
    }
}

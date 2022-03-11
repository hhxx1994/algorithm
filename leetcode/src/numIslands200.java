/**
 * @author huanghaoxing
 */
public class numIslands200 {

    public int numIslands(char[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    ret++;
                }
            }
        }
        return ret;
    }

    private void dfs(int r, int c, char[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }
        if (grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        // 上
        dfs(r - 1, c, grid);
        // 下
        dfs(r + 1, c, grid);
        // 右
        dfs(r, c + 1, grid);
        // 左
        dfs(r, c - 1, grid);
    }
}

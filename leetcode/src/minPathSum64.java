/**
 * @author huanghaoxing
 */
public class minPathSum64 {

    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j > 0) {
                    // 第一行
                    dp[0][j] = dp[0][j - 1] + grid[i][j];
                } else if (j == 0 && i > 0) {
                    // 第一列
                    dp[i][0] = dp[i - 1][0] + grid[i][j];
                } else if (j > 0 && i > 0) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[r - 1][c - 1];
    }

}

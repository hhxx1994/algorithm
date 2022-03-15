/**
 * @author huanghaoxing
 */
public class maximalSquare221 {

    public int maximalSquare(char[][] matrix) {
        int n1 = matrix.length;
        int n2 = matrix[0].length;
        int[][] dp = new int[n1][n2];
        int ret = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                // base case
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else if (matrix[i][j] == '1') {
                    int a = dp[i - 1][j - 1];
                    int b = dp[i][j - 1];
                    int c = dp[i - 1][j];
                    dp[i][j] = Math.min(a, Math.min(b, c)) + 1;
                }
                ret = Math.max(ret, dp[i][j]);
            }
        }

        return ret*ret;
    }
}

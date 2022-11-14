package one;

/**
 * @author huanghaoxing
 */
public class minDistance72 {

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        // base case
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 替换
                    int a = dp[i - 1][j - 1] + 1;
                    // 删除
                    int b = dp[i - 1][j] + 1;
                    // 插入
                    int c = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(a, Math.min(b, c));
                }
            }
        }

        return dp[n1][n2];
    }
}

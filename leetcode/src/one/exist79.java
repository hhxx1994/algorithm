package one;

/**
 * @author huanghaoxing
 */
public class exist79 {

    // 79. 单词搜索
    boolean[][] visited;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int R;
    int C;
    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        R = board.length;
        C = board[0].length;
        this.board = board;
        this.word = word;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[R][C];
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int r, int c, int index) {
        if (index == word.length() - 1 && board[r][c] == word.charAt(index)) {
            return true;
        }

        if (board[r][c] != word.charAt(index)) {
            visited[r][c] = false;
            return false;
        }
        visited[r][c] = true;
        for (int i = 0; i < dirs.length; i++) {
            int nextr = r + dirs[i][0];
            int nextc = c + dirs[i][1];
            if (nextr >= 0 && nextr < R && nextc >= 0 && nextc < C && !visited[nextr][nextc]) {
                if (dfs(nextr, nextc, index + 1)) {
                    return true;
                }
            }
        }
        visited[r][c] = false;
        return false;
    }

    public static void main(String[] args) {
        // new one.exist79().exist()
    }
}

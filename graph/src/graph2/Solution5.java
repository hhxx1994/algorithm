package graph2;

import java.util.*;


/**
 * @author huanghaoxing
 */
public class Solution5 {

    public int slidingPuzzle(int[][] board) {
        String s = boardToString(board);
        if (s.equals("123450")) {
            return -1;
        }
        return bfs(s);
    }

    private int bfs(String s) {
        Set<String> visited = new HashSet<>();
        Map<String, Integer> dirs = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        dirs.put(s, 0);
        while (!queue.isEmpty()) {
            String v = queue.remove();
            int[][] board = stringToBoard(v);
            List<String> nexts = nexts(board);
            for (String next : nexts) {
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                    dirs.put(next, dirs.get(v) + 1);
                    if (next.equals("123450")) {
                        return dirs.get(next);
                    }
                }
            }
        }
        return -1;

    }

    private List<String> nexts(int[][] board) {
        int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        List<String> nexts = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nexti = i + d[k][0];
                        int nextj = j + d[k][1];
                        if (nexti >= 0 && nexti < 2 && nextj >= 0 && nextj < 3) {
                            swap(board, i, j, nexti, nextj);
                            nexts.add(boardToString(board));
                            swap(board, nexti, nextj, i, j);
                        }
                    }
                    break;
                }
            }
        }
        return nexts;
    }

    private void swap(int[][] board, int i, int j, int nexti, int nextj) {
        int temp = board[i][j];
        board[i][j] = board[nexti][nextj];
        board[nexti][nextj] = temp;
    }


    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    private int[][] stringToBoard(String s) {
        int[][] board = new int[2][3];
        for (int i = 0; i < 6; i++) {
            board[i / 3][i % 3] = s.charAt(i) - '0';
        }
        return board;
    }

}

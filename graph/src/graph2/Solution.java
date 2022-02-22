package graph2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean[] visited;
    int R;
    int C;
    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        visited = new boolean[R * C];
        int ret = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int v = i * C + j;
                if (!visited[v] && grid[i][j] == 1) {
                    ret = Math.max(dfs(v), ret);
                }
            }
        }

        return ret;
    }

    private int dfs(int v) {
        int ret = 1;
        visited[v] = true;
        for (int w : adj(v)) {
            if (!visited[w]) {
                ret += dfs(w);
            }
        }
        return ret;
    }

    private List<Integer> adj(int v) {
        List<Integer> adj = new ArrayList<>();
        int r = v / C;
        int c = v % C;
        for (int i = 0; i < dirs.length; i++) {
            int nextr = r + dirs[i][0];
            int nextc = c + dirs[i][1];

            if ((nextr >= 0 && nextr < R && nextc >= 0 && nextc < C) && grid[nextr][nextc] == 1) {
                adj.add(nextr * C + nextc);
            }
        }

        return adj;
    }


}
package graph2;

import java.util.Arrays;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class BipartiteDetection {

    int V;
    int E;
    Set<Integer>[] adj;
    boolean[] visited;
    int[] colors;
    boolean bipartition = true;

    public BipartiteDetection() {
        colors = new int[V];
        Arrays.fill(colors, -1);
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (!dfs(i, 0)) {
                    bipartition = false;
                    break;
                }
            }
        }
    }

    public boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (int w : adj[v]) {
            if (!visited[w]) {
                if (!dfs(w, 1 - color)) {
                    return false;
                }
            } else if (colors[v] == colors[w]) {
                return false;
            }
        }
        return true;
    }

}

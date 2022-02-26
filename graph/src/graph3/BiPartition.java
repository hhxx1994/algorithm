package graph3;

import sun.font.TrueTypeGlyphMapper;

import java.util.Arrays;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class BiPartition {

    Set<Integer>[] adj;
    int V;
    int[] colors;
    boolean[] visited;
    boolean bipatition = true;

    public BiPartition(Set<Integer>[] adj) {
        this.adj = adj;
        V = adj.length;
        colors = new int[V];
        Arrays.fill(colors, -1);
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (!dfs(i, 0)) {
                    bipatition = false;
                    break;
                }
            }
        }

    }

    private boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (Integer w : adj[v]) {
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

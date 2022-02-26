package graph3;

import java.util.Set;

/**
 * @author huanghaoxing
 */
public class DFS {

    Set<Integer>[] adj;
    int V;
    boolean[] visited;
    boolean hasCycle;

    public DFS(Set<Integer>[] adj) {
        this.adj = adj;
        V = adj.length;
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, i)) {
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    private boolean dfs(int v, int parent) {
        visited[v] = true;
        // 前序
        for (Integer w : adj[v]) {
            if (!visited[w]) {
                if (dfs(w, v)) {
                    return true;
                }
            } else if (w != parent) {
                return true;
            }
        }
        // 后续， 回溯
        return false;
    }
}

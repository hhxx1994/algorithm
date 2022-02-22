package graph2;

import java.util.Set;

/**
 * @author huanghaoxing
 */
public class DFS {

    int V;
    int E;
    Set<Integer>[] adj;
    boolean[] visited;

    public DFS() {
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public void dfs(int v) {
        visited[v] = true;
        for (int w : adj[v]) {
            if (!visited[w]) {
                dfs(w);
            }
        }
    }
}

package graph2;

import java.util.Set;

/**
 * @author huanghaoxing
 */
public class CycleDetection {

    int V;
    int E;
    Set<Integer>[] adj;
    boolean[] visited;
    boolean hasCycle = false;

    public CycleDetection() {

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

    public boolean dfs(int v, int parent) {
        visited[v] = true;
        for (int w : adj[v]) {
            if (!visited[w]) {
                if (dfs(w, v)) {
                    return true;
                }
            } else if (w != parent) {
                return true;
            }
        }
        return false;
    }

}

package graph2;

import java.util.Set;

/**
 * @author huanghaoxing
 */
public class DirectCycleDetection {

    int V;
    int E;
    Set<Integer>[] adj;
    boolean[] visited;
    boolean hasCycle = false;
    boolean[] path;

    public DirectCycleDetection() {
        visited = new boolean[V];
        path = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i)) {
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    private boolean dfs(int v) {
        visited[v] = true;
        path[v] = true;
        for (Integer w : adj[v]) {
            if (!visited[w]) {
                if (dfs(v)) {
                    return true;
                }
            } else if (path[w]) {
                return true;
            }
        }
        path[v] = false;
        return false;
    }

}

package graph2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class DirectCycleDetection2 {

    int V;
    int E;
    Set<Integer>[] adj;
    boolean[] visited;
    boolean[] path;
    boolean hasCycle;

    List<Integer> post = new ArrayList<>();

    public DirectCycleDetection2() {

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
                if (dfs(w)) {
                    return true;
                }
            } else if (path[w]) {
                return true;
            }
        }
        post.add(v);
        path[v] = false;
        return false;
    }

}

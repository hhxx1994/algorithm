package graph2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class DirectCycleDetection3 {

    int V;
    int E;
    Set<Integer>[] adj;
    boolean[] visited;
    boolean[] onPath;
    List<Integer> order = new ArrayList<>();

    public boolean hasCycle() {
        visited = new boolean[V];
        onPath = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i)) {
                    order.clear();
                    return true;
                }
            }
        }
        Collections.reverse(order);
        return false;
    }

    private boolean dfs(int v) {
        visited[v] = true;
        onPath[v] = true;
        order.add(v);
        for (Integer w : adj[v]) {
            if (!visited[w]) {
                if (dfs(w)) {
                    return true;
                }
            } else if (onPath[w]) {
                return true;
            }
        }
        onPath[v] = false;
        return false;
    }
}

package graph2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class HamiltonLoop2 {

    Set<Integer>[] adj;
    boolean[] visited;
    List<Integer> order = new ArrayList<>();

    public HamiltonLoop2() {
        visited = new boolean[adj.length];
        dfs(0, adj.length);

    }

    private boolean dfs(int v, int left) {
        visited[v] = true;
        left--;
        order.add(v);
        for (Integer w : adj[v]) {
            if (!visited[w]) {
                if (dfs(w, left)) {
                    return true;
                } else if (w == 0 && left == 0) {
                    return true;
                }
            }
        }
        order.remove(v);
        visited[v] = false;
        return false;
    }
}

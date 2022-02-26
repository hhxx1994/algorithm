package graph3;

import java.util.Set;

/**
 * @author huanghaoxing
 */
public class HamiltonLoop {

    Set<Integer>[] adj;
    boolean[] visited;
    boolean hasHamiltonLoop;

    public HamiltonLoop(Set<Integer>[] adj) {
        this.adj = adj;
        visited = new boolean[adj.length];
        hasHamiltonLoop = dfs(0, adj.length);
    }

    private boolean dfs(int v, int left) {
        visited[v] = true;
        left--;
        for (Integer w : adj[v]) {
            if (!visited[w]) {
                if (dfs(w, left)) {
                    return true;
                }
            } else if (left == 0 && w == 0) {
                return true;
            }
        }
        visited[v] = false;
        return false;
    }
}

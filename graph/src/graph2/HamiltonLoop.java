package graph2;

import java.util.Arrays;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class HamiltonLoop {

    int V;
    int E;
    Set<Integer>[] adj;
    boolean[] visited;
    int[] pre;

    public HamiltonLoop() {
        pre = new int[V];
        Arrays.fill(pre, -1);
        visited = new boolean[V];
        dfs(0, 0, V);
    }

    private boolean dfs(int v, int parent, int left) {
        pre[v] = parent;
        visited[v] = true;
        left--;
        for (Integer w : adj[v]) {
            if (!visited[w]) {
                if (dfs(w, v, left)) {
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

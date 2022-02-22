package graph2;

import java.util.Arrays;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class CC {

    int V;
    int E;
    Set<Integer>[] adj;
    boolean[] visited;
    int[] components;
    int cc;

    public CC() {
        cc = 0;
        components = new int[V];
        Arrays.fill(components, -1);
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, cc);
                cc++;
            }
        }
    }

    public void dfs(int v, int cc) {
        visited[v] = true;
        components[v] = cc;
        for (int w : adj[v]) {
            if (!visited[w]) {
                dfs(w, cc);
            }
        }
    }

}

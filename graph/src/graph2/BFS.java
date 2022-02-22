package graph2;

import java.util.*;

/**
 * @author huanghaoxing
 */
public class BFS {

    int V;
    int E;
    Set<Integer>[] adj;
    boolean[] visited;
    List<Integer> order = new ArrayList<>();
    public BFS() {
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }
    }

    private void bfs(int v) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            Integer w = queue.remove();
            order.add(w);
            for (int ww : adj[w]) {
                if (!visited[ww]) {
                    queue.add(ww);
                    visited[ww] = true;
                }
            }
        }
    }
}

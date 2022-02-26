package graph3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class BFS {
    Set<Integer>[] adj;
    int V;
    boolean[] visited;

    public BFS(Set<Integer>[] adj) {
        this.adj = adj;
        V = adj.length;
        visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            Integer v = queue.remove();

            for (Integer w : adj[v]) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                }
            }
        }

    }
}

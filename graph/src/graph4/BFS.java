package graph4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {

    Set<Integer>[] adj;

    public BFS(Set<Integer>[] adj) {
        this.adj = adj;
        boolean[] visited = new boolean[adj.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int v = queue.remove();
                for (int next : adj[v]) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
    }

}

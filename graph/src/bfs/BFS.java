package bfs;

import graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class BFS {
    private Graph g;
    private boolean[] visited;
    private List<Integer> path;

    public BFS(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        path = new ArrayList<>();
        for (int i = 0; i < g.V(); i++) {
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
            Integer vv = queue.remove();
            path.add(vv);
            for (Integer w : g.adj(vv)) {
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    public List<Integer> path() {
        return path;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("graph/src/bfs/g.txt");
        BFS bfs = new BFS(graph);
        for (Integer w : bfs.path()) {
            System.out.print(w);
            System.out.print(",");
        }
    }
}

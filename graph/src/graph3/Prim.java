package graph3;

import java.util.*;

/**
 * @author huanghaoxing
 */
public class Prim {

    Map<Integer, Integer>[] adj;
    boolean[] visited;

    class Edge implements Comparable<Edge> {
        int v;
        int weight;
        int w;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public int compareTo(Edge e) {
            return weight - e.weight;
        }
    }

    public Prim(Map<Integer, Integer>[] adj) {
        this.adj = adj;
        visited = new boolean[adj.length];
        Queue<Edge> queue = new PriorityQueue<>();
        for (Integer w : adj[0].keySet()) {
            queue.add(new Edge(0, w, adj[0].get(w)));
        }
        List<Edge> edges = new ArrayList<>();
        while (!queue.isEmpty()) {
            Edge edge = queue.remove();
            int v = edge.v;
            int w = edge.w;
            if (visited[v] && visited[w]) {
                continue;
            }
            int newv = visited[v] ? w : v;
            visited[newv] = true;
            edges.add(edge);
            for (Integer neww : adj[newv].keySet()) {
                if (!visited[neww]) {
                    queue.add(new Edge(newv, neww, adj[newv].get(neww)));
                }
            }
        }
    }

}

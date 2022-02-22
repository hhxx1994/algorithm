package graph2;

import java.util.*;

/**
 * @author huanghaoxing
 */
public class Prim3 {

    Map<Integer, Integer>[] adj;

    class Edge implements Comparable<Edge> {

        int v;
        int w;
        int weight;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    public Prim3() {
        List<Edge> edges = new ArrayList<>();
        boolean[] visited = new boolean[adj.length];
        Queue<Edge> queue = new PriorityQueue<>();
        for (Integer v : adj[0].keySet()) {
            queue.add(new Edge(0, v, adj[0].get(v)));
        }

        while (!queue.isEmpty()) {
            Edge edge = queue.remove();
            if (visited[edge.v] && visited[edge.w]) {
                continue;
            }
            edges.add(edge);
            int newv = visited[edge.v] ? edge.w : edge.v;
            visited[newv] = true;
            for (Integer w : adj[newv].keySet()) {
                if (!visited[w]) {
                    queue.add(new Edge(newv, w, adj[newv].get(w)));
                }
            }
        }

    }
}

package one;

import java.util.*;

/**
 * @author huanghaoxing
 */
public class Prim {

    class Edge implements Comparable<Edge> {
        int v;
        int w;
        int weight;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    Map<Integer, Integer>[] adj;

    public Prim(Map<Integer, Integer>[] adj) {
        this.adj = adj;
        boolean[] visited = new boolean[adj.length];
        List<Edge> mst = new ArrayList<>();
        Queue<Edge> queue = new PriorityQueue<>();
        for (Integer w : adj[0].keySet()) {
            queue.add(new Edge(0, w, weight(0, w)));
        }

        while (!queue.isEmpty()) {
            Edge edge = queue.remove();
            // 选边
            if (visited[edge.v] && visited[edge.w]) {
                continue;
            }
            mst.add(edge);

            int newv = visited[edge.v] ? edge.w : edge.v;
            visited[newv] = true;

            for (Integer neww : adj[newv].keySet()) {
                if (!visited[neww]) {
                    queue.add(new Edge(newv, neww, weight(newv, neww)));
                }
            }
        }

    }

    public int weight(int i, int j) {
        return adj[i].get(j);
    }

}

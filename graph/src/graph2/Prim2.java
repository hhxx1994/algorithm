package graph2;

import java.util.*;

/**
 * @author huanghaoxing
 */
public class Prim2 {

    int V;
    int E;
    Map<Integer, Integer>[] adj;

    class Node implements Comparable<Node> {
        int v;
        int w;
        int weight;

        public Node(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public Prim2() {
        boolean[] visited = new boolean[V];
        Queue<Node> queue = new PriorityQueue<>();
        for (Integer v : adj[0].keySet()) {
            queue.add(new Node(0, v, adj[0].get(v)));
        }
        visited[0] = true;
        List<Node> mst = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int v = node.v;
            int w = node.w;

            if (visited[v] && visited[w]) {
                continue;
            }
            mst.add(node);
            int newv = visited[v] ? w : v;
            visited[newv] = true;
            for (Integer neww : adj[newv].keySet()) {
                if (!visited[neww]) {
                    queue.add(new Node(newv, neww, adj[newv].get(neww)));
                }
            }

        }
    }
}

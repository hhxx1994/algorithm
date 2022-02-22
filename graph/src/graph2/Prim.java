package graph2;

import java.util.*;

/**
 * @author huanghaoxing
 */
public class Prim {
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

    public Prim() {
        List<Node> mst = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Node> queue = new PriorityQueue<>();
        for (Integer w : adj[0].keySet()) {
            queue.add(new Node(0, w, adj[0].get(w)));
        }

        visited[0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int v = node.v;
            int w = node.w;
            if (visited[v] && visited[w]) {
                continue;
            }
            mst.add(node);
            int newv = visited[v] ? node.w : v;
            visited[newv] = true;
            for (Integer neww : adj[newv].keySet()) {
                if (!visited[neww]) {
                    queue.add(new Node(newv, w, adj[newv].get(neww)));
                }
            }


        }
    }
}

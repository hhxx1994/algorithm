package graph3;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class Dijkstra {

    class Node implements Comparable<Node> {
        int v;
        int dir;

        public Node(int v, int dir) {
            this.v = v;
            this.dir = dir;
        }

        public int compareTo(Node o) {
            return dir - o.dir;
        }
    }

    public Dijkstra(Map<Integer, Integer>[] adj) {

        int[] dirs = new int[adj.length];
        Arrays.fill(dirs, Integer.MAX_VALUE);
        dirs[0] = 0;
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0));
        boolean[] visited = new boolean[adj.length];

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int v = node.v;
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            for (Integer w : adj[v].keySet()) {
                if (!visited[w]) {
                    if (dirs[v] + adj[v].get(w) < dirs[w]) {
                        dirs[w] = dirs[v] + adj[v].get(w);
                        queue.add(new Node(w, dirs[w]));
                    }
                }
            }
        }
    }
}

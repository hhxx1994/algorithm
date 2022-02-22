package graph2;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class Dijsktra2 {

    int V;
    int E;
    Map<Integer, Integer>[] adj;

    class Node implements Comparable<Node> {
        int v;
        int dir;

        public Node(int v, int dir) {
            this.v = v;
            this.dir = dir;
        }

        @Override
        public int compareTo(Node o) {
            return dir - o.dir;
        }
    }

    public Dijsktra2() {

        int[] dirs = new int[V];
        Arrays.fill(dirs, Integer.MAX_VALUE);
        dirs[0] = 0;
        boolean[] visited = new boolean[V];
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {

            Node node = queue.remove();

            int v = node.v;
            int dir = node.dir;
            if (visited[v]) {
                continue;
            }

            visited[v] = true;
            for (Integer w : adj[v].keySet()) {
                if (!visited[w]) {
                    if (adj[v].get(w) + dir < dirs[w]) {
                        dirs[w] = adj[v].get(w) + dir;
                    }
                }
            }

        }

    }

}

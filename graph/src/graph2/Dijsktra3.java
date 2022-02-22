package graph2;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class Dijsktra3 {

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

        public int compareTo(Node o) {
            return dir - o.dir;
        }
    }

    public Dijsktra3(int source) {
        boolean[] visited = new boolean[V];
        int[] dirs = new int[V];
        Arrays.fill(dirs, Integer.MAX_VALUE);
        dirs[source] = 0;
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(source, 0));

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
                    if (dir + adj[v].get(w) < dirs[w]) {
                        dirs[w] = dir + adj[v].get(w);
                        queue.add(new Node(w, dirs[w]));
                    }
                }
            }

        }

    }

}

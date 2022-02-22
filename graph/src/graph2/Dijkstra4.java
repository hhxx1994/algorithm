package graph2;

import java.util.*;

/**
 * @author huanghaoxing
 */
public class Dijkstra4 {

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

    public void dijkstra(int source) {
        boolean[] visited = new boolean[V];
        int[] dirs = new int[V];
        int[] pre = new int[V];
        Arrays.fill(pre, -1);
        Arrays.fill(dirs, Integer.MAX_VALUE);
        dirs[source] = 0;
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(source, 0));
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
                        pre[w] = v;
                        dirs[w] = dirs[v] + adj[v].get(w);
                        queue.add(new Node(w, dirs[w]));
                    }
                }
            }

        }

    }
}

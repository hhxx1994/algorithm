package one;


import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class Dijkstra {

    Map<Integer, Integer>[] adj;

    class Node implements Comparable<Node> {

        int v;
        int dir;

        public Node(int v, int dir) {
            this.dir = dir;
            this.v = v;
        }

        public int compareTo(Node o) {
            return dir - o.dir;
        }
    }

    public Dijkstra(Map<Integer, Integer>[] adj, int s) {
        this.adj = adj;
        int[] dirs = new int[adj.length];
        Arrays.fill(dirs, Integer.MAX_VALUE);
        dirs[s] = 0;
        boolean[] visited = new boolean[adj.length];
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(s, 0));
        int[] pre = new int[adj.length];
        Arrays.fill(pre, -1);
        pre[s] = s;
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int v = node.v;
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            for (Integer w : adj[v].keySet()) {
                if (!visited[w]) {
                    if (dirs[v] + dir(v, w) < dirs[w]) {
                        dirs[w] = dirs[v] + dir(v, w);
                        queue.add(new Node(w, dirs[w]));
                        pre[w] = v;
                    }
                }
            }
        }
    }

    private int dir(int v, int w) {
        return adj[v].get(w);
    }
}

package bfs;

import graph.Graph;

import java.util.*;

/**
 * @author huanghaoxing
 * 无向无权图的最短路径问题
 */
public class UnWeightShortedPath {
    private Graph g;
    private int[] pre;
    private int[] dis;
    private int s;
    private int d;

    public UnWeightShortedPath(Graph g, int s, int d) {
        this.s = s;
        this.d = d;
        this.g = g;
        pre = new int[g.V()];
        dis = new int[g.V()];
        Arrays.fill(pre, -1);
        Arrays.fill(dis, -1);
        bfs(s, d);
    }

    private void bfs(int s, int d) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        pre[s] = s;
        dis[s] = 0;
        while (!queue.isEmpty()) {
            Integer vv = queue.remove();
            if (vv == d) {
                break;
            }
            for (Integer w : g.adj(vv)) {
                if (pre[w] == -1) {
                    pre[w] = vv;
                    dis[w] = dis[vv] + 1;
                    queue.add(w);
                }
            }
        }
    }

    public List<Integer> path() {
        List<Integer> path = new LinkedList<>();
        if (pre[d] == -1) {
            return path;
        }
        int t = d;
        while (t != s) {
            path.add(t);
            t = pre[t];
        }
        path.add(s);
        Collections.reverse(path);
        return path;
    }

    public int dis() {
        return dis[d];
    }

    public static void main(String[] args) {
        Graph graph = new Graph("graph/src/bfs/g.txt");
        UnWeightShortedPath unWeightShortedPath = new UnWeightShortedPath(graph, 0, 6);
        List<Integer> path = unWeightShortedPath.path();
        for (Integer p : path) {
            System.out.print(p);
            System.out.print(",");
        }
        System.out.println();
        System.out.println(unWeightShortedPath.dis());
    }
}

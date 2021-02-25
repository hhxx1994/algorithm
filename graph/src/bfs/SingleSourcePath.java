package bfs;

import graph.Graph;

import java.util.*;

/**
 * @author huanghaoxing
 */
public class SingleSourcePath {
    private Graph g;
    private int[] pre;
    private int s;

    public SingleSourcePath(Graph g, int s) {
        this.g = g;
        this.s = s;
        pre = new int[g.V()];
        Arrays.fill(pre, -1);
        bfs(s);
    }

    private void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        pre[v] = v;
        while (!queue.isEmpty()) {
            Integer vv = queue.remove();
            for (Integer w : g.adj(vv)) {
                if (pre[w] == -1) {
                    pre[w] = vv;
                    queue.add(w);
                }
            }
        }
    }

    public List<Integer> path(int d) {
        List<Integer> path = new ArrayList<>();
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

    public static void main(String[] args) {
        Graph graph = new Graph("graph/src/bfs/g.txt");
        SingleSourcePath singleSourcePath = new SingleSourcePath(graph, 0);
        List<Integer> path = singleSourcePath.path(6);
        for (Integer p : path) {
            System.out.print(p);
            System.out.print(",");
        }
    }
}

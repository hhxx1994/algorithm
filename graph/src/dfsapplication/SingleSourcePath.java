package dfsapplication;

import graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        /**
         *  源头 s = pre[s]
         */
        dfs(s, s);
    }

    /**
     * @param v
     * @param p 父节点
     */
    private void dfs(int v, int p) {
        pre[v] = p;
        for (Integer w : g.adj(v)) {
            if (pre[w] == -1) {
                dfs(w, v);
            }
        }
    }

    public List<Integer> path(int d) {
        // s,d 是否连通
        if (pre[d] == -1) {
            return null;
        }
        List<Integer> path = new ArrayList<>();
        int t = d;
        while (s != t) {
            path.add(t);
            t = pre[t];
        }
        path.add(s);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("graph/src/dfsapplication/g.txt");
        SingleSourcePath singleSourcePath = new SingleSourcePath(graph, 0);
        List<Integer> path = singleSourcePath.path(6);
        for (Integer p : path) {
            System.out.print(p);
            System.out.print(",");
        }
    }

}

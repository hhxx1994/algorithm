package graph2;

import java.util.*;

/**
 * @author huanghaoxing
 */
public class SingleSourcePath {

    int V;
    int E;
    Set<Integer>[] adj;
    boolean[] visited;

    int s;
    int[] pre;
    int[] dirs;

    public SingleSourcePath() {
        pre = new int[V];
        Arrays.fill(pre, -1);
        dirs = new int[V];
        Arrays.fill(dirs, 0);
        visited = new boolean[V];
        bfs(s);
    }

    private void bfs(int v) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        pre[v] = v;
        while (!queue.isEmpty()) {
            Integer w = queue.remove();
            for (int ww : adj[w]) {
                if (!visited[ww]) {
                    queue.add(ww);
                    pre[ww] = w;
                    dirs[ww] = dirs[w] + 1;
                    visited[ww] = true;
                }
            }
        }
    }

    private boolean isConnect(int v) {
        return visited[v];
    }

    private List<Integer> path(int v) {
        if (!isConnect(v)) {
            return null;
        }
        List<Integer> path = new ArrayList<>();

        int cur = v;
        while (cur != s) {
            path.add(cur);
            cur = pre[cur];
        }
        path.add(s);
        Collections.reverse(path);
        return path;
    }
}

package graph2;

import java.util.Arrays;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class Dijsktra {

    int V;
    int E;
    Map<Integer, Integer>[] adj;

    public Dijsktra() {
        int[] dirs = new int[V];
        Arrays.fill(dirs, Integer.MAX_VALUE);
        dirs[0] = 0;
        boolean[] visited = new boolean[V];
        while (true) {

            int curdir = Integer.MAX_VALUE;
            int cur = -1;
            for (int i = 0; i < V; i++) {
                if (!visited[i] && dirs[i] < curdir) {
                    curdir = dirs[i];
                    cur = i;
                }
            }

            if (cur == -1) {
                break;
            }

            visited[cur] = true;
            for (Integer w : adj[cur].keySet()) {
                if (!visited[w] && curdir + adj[cur].get(w) < dirs[w]) {
                    dirs[w] = curdir + adj[cur].get(w);
                }
            }

        }

    }
}

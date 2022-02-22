package graph2;

import java.util.*;

/**
 * @author huanghaoxing
 */
public class TopoSort {

    int V;
    int E;
    Set<Integer>[] adj;
    int[] inDegree;
    boolean hasCycle;

    public TopoSort() {
        inDegree = new int[V];
        for (Set<Integer> s : adj) {
            for (Integer v : s) {
                inDegree[v]++;
            }
        }

        List<Integer> ret = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer v = queue.remove();
            ret.add(v);
            for (Integer w : adj[v]) {
                inDegree[w]--;
                if (inDegree[w] == 0) {
                    queue.add(w);
                }
            }
        }
        if (ret.size() != V) {
            hasCycle = true;
        }

    }

}

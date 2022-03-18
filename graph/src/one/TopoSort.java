package one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class TopoSort {


    Set<Integer>[] adj;
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle;
    List<Integer> order = new ArrayList<>();

    public TopoSort(Set<Integer>[] adj) {
        this.adj = adj;
        visited = new boolean[adj.length];
        onPath = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                if (dfs(i)) {
                    hasCycle = true;
                    order.clear();
                    break;
                }
            }
        }
        if (!hasCycle) {
            Collections.reverse(order);
        }

    }

    private boolean dfs(int v) {
        visited[v] = true;
        onPath[v] = true;
        for (Integer w : adj[v]) {
            if (!visited[w]) {
                if (dfs(w)) {
                    return true;
                }
            } else if (onPath[w]) {
                return true;
            }
        }
        order.add(v);
        onPath[v] = false;
        return false;
    }

}

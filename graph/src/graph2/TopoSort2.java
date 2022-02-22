package graph2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class TopoSort2 {

    int[] indegrees;
    int V;
    List<Integer> order = new ArrayList<>();
    int[][] grid;
    boolean hasCycle;

    public void topoSort(int[][] grid) {
        this.grid = grid;
        V = grid.length;
        indegrees = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                indegrees[j] += grid[i][j];
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer v = queue.remove();
            order.add(v);
            for (int w : grid[v]) {
                indegrees[w]--;
                if (indegrees[w] == 0) {
                    queue.add(w);
                }

            }
        }
        if (V != order.size()) {
            hasCycle = true;
        }

    }

}

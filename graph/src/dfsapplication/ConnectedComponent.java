package dfsapplication;

import graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huanghaoxing
 * 联通分量
 */
public class ConnectedComponent {
    private Graph g;
    private int[] visited;
    private int ccount;

    public ConnectedComponent(Graph g) {
        this.g = g;
        visited = new int[g.V()];
        Arrays.fill(visited, -1);
        for (int i = 0; i < g.V(); i++) {
            if (visited[i] == -1) {
                dfs(i, ccount);
                ccount++;
            }
        }
    }

    private void dfs(int v, int ccount) {
        visited[v] = ccount;
        for (Integer w : g.adj(v)) {
            if (visited[w] == -1) {
                dfs(w, ccount);
            }
        }
    }

    public List<Integer>[] component() {
        List<Integer>[] component = new List[ccount];
        for (int i = 0; i < ccount; i++) {
            component[i] = new ArrayList<>();
        }
        for (int i = 0; i < visited.length; i++) {
            component[visited[i]].add(i);
        }
        return component;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("graph/src/dfsapplication/g.txt");
        ConnectedComponent component = new ConnectedComponent(graph);
        for (List<Integer> c : component.component()) {
            for (Integer v : c) {
                System.out.print(v);
                System.out.print(",");
            }
            System.out.println();
        }
    }

}

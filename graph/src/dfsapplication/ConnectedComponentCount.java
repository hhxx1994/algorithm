package dfsapplication;

import graph.Graph;

/**
 * @author huanghaoxing
 */
public class ConnectedComponentCount {
    private Graph g;
    private boolean[] visited;
    /**
     * 联通分量
     */
    private int ccount;

    public ConnectedComponentCount(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                ccount++;
                dfs(i);
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        for (Integer w : g.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph("graph/src/dfsapplication/g.txt");
        ConnectedComponentCount cc = new ConnectedComponentCount(graph);
        System.out.println(cc.ccount);
    }
}

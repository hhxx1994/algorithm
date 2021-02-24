package dfsapplication;

import graph.Graph;

/**
 * @author huanghaoxing
 */
public class CycleDetection {
    private Graph g;
    private boolean[] visited;
    private boolean cycle;

    public CycleDetection(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                if (dfs(i, i)) {
                    cycle = true;
                    break;
                }
            }
        }
    }

    public boolean cycle() {
        return cycle;
    }

    private boolean dfs(int v, int parent) {
        visited[v] = true;
        for (Integer w : g.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) {
                    return true;
                }
            } else if (w != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("graph/src/dfsapplication/g.txt");
        CycleDetection cycleDetection = new CycleDetection(graph);
        System.out.println(cycleDetection.cycle());
    }
}

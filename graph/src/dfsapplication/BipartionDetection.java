package dfsapplication;

import graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class BipartionDetection {
    private Graph g;
    private int[] visited;
    private boolean bipartion = true;

    public BipartionDetection(Graph g) {
        this.g = g;
        visited = new int[g.V()];
        Arrays.fill(visited, -1);
        for (int i = 0; i < g.V(); i++) {
            if (visited[i] == -1) {
                if (!dfs(i, 0)) {
                    bipartion = false;
                    break;
                }
            }
        }

    }

    private boolean dfs(int v, int color) {
        visited[v] = color;
        for (Integer w : g.adj(v)) {
            if (visited[w] == -1) {
                if (!dfs(w, 1 - color)) {
                    return false;
                }
            } else if (visited[w] == color) {
                // 邻居顶点颜色相同==>非二部图
                return false;
            }
        }
        return true;
    }

    public boolean bipartion() {
        return bipartion;
    }

    public List<Integer>[] partion() {
        if (!bipartion) {
            return null;
        }
        List<Integer>[] partion = new List[2];
        partion[0] = new ArrayList<>();
        partion[1] = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            partion[visited[i]].add(i);
        }
        return partion;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("graph/src/dfsapplication/g.txt");
        BipartionDetection bipartionDetection = new BipartionDetection(graph);
        System.out.println(bipartionDetection.bipartion);
        if (bipartionDetection.bipartion) {
            List<Integer>[] partion = bipartionDetection.partion();
            for (List<Integer> list : partion) {
                for (Integer v : list) {
                    System.out.print(v);
                    System.out.print(",");
                }
                System.out.println();
            }
        }
    }

}

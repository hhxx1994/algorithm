import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author huanghaoxing
 * 无向图
 */
public class Graph {
    private int E;
    private int V;
    private TreeSet<Integer>[] adj;

    public Graph(String path) {
        buildGraph(path);
    }


    public int E() {
        return E;
    }

    public int V() {
        return V;
    }

    /**
     * 邻接顶点
     *
     * @param v
     * @return
     */
    public Set<Integer> adj(int v) {
        return adj[v];
    }

    public int degree(int v) {
        return adj(v).size();
    }


    public void buildGraph(String path) {
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            V = scanner.nextInt();
            E = scanner.nextInt();
            adj = new TreeSet[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new TreeSet<>();
            }
            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                adj[w].add(v);
                adj[v].add(w);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

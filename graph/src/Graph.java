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

    public int E() {
        return E;
    }

    public int V() {
        return V;
    }

    public Set<Integer> adj(int v) {
        return adj[v];
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
            while (scanner.hasNext()) {
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

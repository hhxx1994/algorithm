import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 * 深度优先遍历
 */
public class DFS {
    private Graph G;
    boolean[] visited;
    List<Integer> pre;
    List<Integer> post;

    public DFS(Graph G) {
        this.G = G;
        visited = new boolean[G.V()];
        pre = new ArrayList<>();
        post = new ArrayList<>();
        // 联通图
        dfs(0);
    }

    private void dfs(int v) {
        // visit v
        pre.add(v);
        visited[v] = true;
        // 访问v节点的邻接点
        for (Integer w : G.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
        post.add(v);
    }

    public static void main(String[] args) {
        Graph graph = new Graph("graph/src/g.txt");
        DFS dfs = new DFS(graph);
        for (Integer v : dfs.pre) {
            System.out.print(v);
            System.out.print(",");
        }

    }

}

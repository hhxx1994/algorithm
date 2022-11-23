package graph4;

import java.util.Set;

public class DFS {

    Set<Integer>[] adj;
    boolean[] visited;

    public DFS(Set<Integer>[] adj) {
        this.adj = adj;
        visited = new boolean[adj.length];
    }

    public void dfs(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        // 前序
        // 关注节点
        for (int w : adj[v]) {
            // 关注树枝【回溯算法】
            dfs(w);
        }
        // 后序
    }
}

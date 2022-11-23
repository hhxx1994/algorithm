package two;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    Set<Integer>[] adj;
    boolean[] visited;
    boolean[] path;
    boolean hasCycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.adj = buildGraph(numCourses,prerequisites);
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        for(int i = 0; i < numCourses ; i++){
            dfs(i);
        }
        return !hasCycle;
    }

    public void dfs(int s){

        if(path[s]){
            hasCycle = true;
            return;
        }

        if(visited[s]){
            return;
        }
        path[s] = true;
        visited[s] = true;
        for(int v : adj[s]){
            dfs(v);
        }

        path[s] = false;
    }

    public Set<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        Set<Integer>[] adj = new Set[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            adj[i] = new HashSet<>();
        }
        for (int[] prerequisite : prerequisites) {
            int v = prerequisite[0];
            int w = prerequisite[1];
            adj[w].add(v);
        }
        return adj;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,0}};
        System.out.println(new HasCycle().canFinish(2, prerequisites));
    }

}

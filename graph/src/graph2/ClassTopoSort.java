package graph2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author huanghaoxing
 */
public class ClassTopoSort {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            indegrees[prerequisites[i][0]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        int num = 0;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            num++;
            for (Integer w : adj[v]) {
                indegrees[w]--;
                if (indegrees[w] == 0) {
                    queue.add(w);

                }
            }
        }
        return num == numCourses;
    }

    boolean[] visited;
    Set<Integer>[] adj;
    boolean[] onPath;

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int v) {
        visited[v] = true;
        onPath[v] = true;
        for (Integer w : adj[v]) {
            if (!visited[w]) {
                if (dfs(w)) {
                    return true;
                }
            } else if (onPath[w]) {
                return true;
            }
        }
        onPath[v] = false;
        return false;
    }

    public static void main(String[] args) {
        ClassTopoSort classTopoSort = new ClassTopoSort();
        int[][] ints = {{1, 0}};
        System.out.println(classTopoSort.canFinish2(2, ints));
    }
}

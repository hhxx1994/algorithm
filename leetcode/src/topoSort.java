import java.util.*;

/**
 * @author huanghaoxing
 */
public class topoSort {

    Set<Character> visited;
    Map<Character, List<Character>> adj;
    Set<Character> path;
    List<Character> order = new ArrayList<>();

    public List<Character> sort(char[][] arr) {
        visited = new HashSet<>();
        path = new HashSet<>();
        adj = new HashMap<>();
        for (char[] a : arr) {
            List<Character> list = adj.getOrDefault(a[0], new ArrayList<>());
            list.add(a[1]);
            adj.put(a[0], list);
        }
        for (Character v : adj.keySet()) {
            if (!visited.contains(v)) {
                if (dfs(v)) {
                    return new ArrayList<>();
                }
            }
        }
        Collections.reverse(order);
        return order;
    }

    public boolean dfs(char v) {
        visited.add(v);
        path.add(v);
        for (Character w : adj.get(v)) {
            if (!visited.contains(w)) {
                dfs(w);
            } else if (path.contains(w)) {
                return true;
            }
        }
        path.remove(v);
        order.add(v);
        return false;
    }
}

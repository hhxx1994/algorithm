package one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class UnionFind {

  private Map<String, Integer> rank;
  private Map<String, String> parent;

  public UnionFind() {
    rank = new HashMap<>();
    parent = new HashMap<>();
  }

  public void union(String p, String q) {
    String pRoot = find(p);
    String qRoot = find(q);
    if (pRoot.equals(qRoot)) {
      return;
    }

    if (rank(pRoot) < rank(qRoot)) {
      rank.put(pRoot, rank(qRoot));
    } else if (rank(qRoot) < rank(pRoot)) {
      rank.put(qRoot, rank(pRoot));
    } else {
      rank.put(pRoot, rank(pRoot) + 1);
      parent.put(qRoot, pRoot);
    }

  }

  private Integer rank(String p) {
    return rank.getOrDefault(p, 1);
  }

  public String find(String p) {

    while (!p.equals(parent.getOrDefault(p, p))) {
      parent.put(p, parent.get(p));
      p = parent.get(p);
    }
    return p;
  }

  public boolean isConnect(String p, String q) {
    return find(p).equals(find(q));
  }

}

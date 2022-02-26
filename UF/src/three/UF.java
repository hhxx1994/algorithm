package three;

/**
 * @author huanghaoxing
 */
public class UF {

    int[] parent;
    int[] rank;

    public UF(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public boolean isConnect(int q, int p) {
        return find(q) == find(p);
    }

    public int find(int q) {

        while (q != parent[q]) {
            q = parent[q];
            // 路径压缩
            // ....
        }
        return q;
    }

    public void union(int q, int p) {
        int qRoot = find(q);
        int pRoot = find(p);
        if (qRoot == pRoot) {
            return;
        }
        if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else if (rank[qRoot] > rank[pRoot]) {
            parent[pRoot] = qRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
    }
}

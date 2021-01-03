package two;

/**
 * @author huanghaoxing
 */
public class UF {
    int[] parent;
    int[] rank;

    public UF(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        // 已经是一个集合
        if (pRoot == qRoot) {
            return;
        }

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    private int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }


    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

}

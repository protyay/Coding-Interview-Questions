public class UnionFind {
    private final int[] parent;
    private final int[] size;
    private int components;

    UnionFind(int vertex) {
        this.components = vertex;
        this.parent = new int[vertex];
        this.size = new int[vertex];

        for (int i = 0; i < vertex; i++) {
            this.parent[i] = i;// Each component is now it's own parent
            this.size[i] = 1;
        }
    }

    private int findParent(int vertex) {
        int root = vertex;
        while (root != parent[root])
            root = parent[root];
        // Path compression which gives us a nice amortized linear complexity
        while (vertex != root) {
            int next = parent[vertex];
            parent[vertex] = root;
            vertex = next;
        }
        return root;
    }

    public void unite(int x, int y) {
        int rootX = findParent(x);
        int rootY = findParent(y);

        if (rootX == rootY)
            return; // Already in the same componenet. No need to re-join.

        if (size[rootX] < size[rootY]) {
            size[rootY] += size[rootX];
            parent[rootX] = rootY;
            size[rootX] = 0;
        } else {
            size[rootX] += size[rootY];
            parent[rootY] = rootX;
            size[rootY] = 0;
        }
        this.components--;
    }

    public int findLargestComp() {
        int maxSize = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i)
                maxSize = Math.max(maxSize, size[i]);
        }
        return maxSize;
    }

    public int getTotalComponents() {
        return this.components;
    }

}
/**
 * Why do we need Union Find ? Do merge separte groups together TC - O(M + NlgN)
 * M represents M operation of UF on a set of N objects
 */
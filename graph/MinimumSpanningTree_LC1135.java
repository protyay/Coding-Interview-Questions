import java.util.Arrays;

public class MinimumSpanningTree_LC1135 {
    public int minimumCost(int n, int[][] connections) {
        int cost = 0;
        Arrays.sort(connections, (a, b) -> Integer.compare(a[2], b[2]));
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < connections.length; i++) {
            int from = connections[i][0], to = connections[i][1];
            if (uf.isConnected(from, to))
                continue;
            uf.unite(from, to);
            cost += connections[i][2];
        }
        return uf.getComponents() > 1 ? -1 : cost;
    }

    class UnionFind {
        private final int[] parent;
        private final int[] size;
        private int components;

        UnionFind(int vertex) {
            this.components = vertex;
            this.parent = new int[vertex + 1];
            this.size = new int[vertex + 1];

            for (int i = 0; i <= vertex; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
            this.size[0] = 0;
        }

        public int findParent(int vertex) {
            int root = vertex;
            while (root != parent[root])
                root = parent[root];

            // Path Compressioin
            while (vertex != root) {
                int next = parent[vertex];
                parent[vertex] = root;
                vertex = next;
            }
            return root;
        }

        public boolean isConnected(int cityA, int cityB) {
            return findParent(cityA) == findParent(cityB);
        }

        public void unite(int x, int y) {
            int rootX = findParent(x);
            int rootY = findParent(y);

            if (rootX == rootY)
                return;

            if (size[rootX] < size[rootY]) {
                this.size[rootY] += this.size[rootX];
                this.parent[rootX] = rootY;
                this.size[rootX] = 0;
            } else {
                this.size[rootX] += this.size[rootY];
                this.parent[rootY] = rootX;
                this.size[rootY] = 0;
            }
            this.components--;
        }

        public int getComponents() {
            return this.components;
        }
    }
}

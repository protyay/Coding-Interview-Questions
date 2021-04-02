import java.util.Arrays;

public class UniounFind {
    // This is weighted Unioun Find with Path compression - (M + N)Log N
    private final int[] parent;
    private final int[] size;
    private final int vertexCount;

    public UniounFind(int N) {
        this.parent = new int[N];
        for (int i = 0; i < parent.length; i++) {
            this.parent[i] = i;
        }
        this.size = new int[N];
        Arrays.fill(size, 1);// Initial state is 1 - All vertex is itself a component
        this.vertexCount = N;
    }

    public int findParent(int vertex) {
        int root = vertex;
        while (this.parent[root] != root) {
            root = this.parent[root];
        }
        // Path compression
        while (vertex != root) {
            int temp = this.parent[vertex];
            this.parent[vertex] = root;
            vertex = temp;
        }
        return root;
    }

    public void unify(int rootA, int rootB) {
        if (this.size[rootA] < this.size[rootB]) {
            this.parent[rootA] = rootB;
            this.size[rootB] += this.size[rootA];
        } else {
            this.parent[rootB] = rootA;
            this.size[rootA] += this.size[rootB];
        }
    }

    public int findComponents() {
        int components = 0;
        for (int i = 0; i < this.vertexCount; i++) {
            if (this.parent[i] == i)
                ++components;
        }
        return components;
    }
}

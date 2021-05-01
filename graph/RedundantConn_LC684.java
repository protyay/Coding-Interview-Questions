import java.util.Arrays;

/**
 * https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf Weighted Unioun
 * with path compression reduces time complexity to (M+N)Log N M is the no of
 * U-F operations on a set of N
 */
public class RedundantConn_LC684 {
    public int[] findRedundantConnection(int[][] edges) {
        // Find the number of vertices
        int N = 0;
        for (int[] edge : edges) {
            N = Math.max(N, Math.max(edge[0], edge[1]));
        }
        int[] parent = new int[N + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        // We need to keep track of size of each component which is to be used
        // in the unifying operation
        int[] size = new int[N + 1];
        // Each component is of size 1 at the start
        Arrays.fill(size, 1);

        int[] ans = new int[2];
        // Traverse through each edge
        for (int[] edge : edges) {
            if (!unify(edge, parent, size)) {
                ans = edge;
            }
        }
        return ans;
    }

    // Finds the parent the given vertex belongs to. Implement path compression
    private int find(int vertex, int[] parent) {
        int root = vertex;
        while (parent[root] != root) {
            root = parent[root];
        }
        while (root != vertex) {
            int next = parent[vertex];
            parent[vertex] = root;
            vertex = next;
        }
        return root;
    }

    private boolean unify(int[] edge, int[] parent, int[] size) {
        int vA = edge[0], vB = edge[1];
        int parentA = find(vA, parent);
        int parentB = find(vB, parent);

        if (parentA == parentB)
            return false;
        // We go ahead with the unifying operation
        if (size[parentA] > size[parentB]) {
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
        } else {
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
        }

        return true;
    }
}

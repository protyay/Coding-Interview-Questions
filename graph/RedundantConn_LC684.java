import java.util.Arrays;

/**
 * https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf Weighted Unioun
 * with path compression reduces time complexity to (M+N)Log N M is the no of
 * U-F operations on a set of N
 */
public class RedundantConn_LC684 {
    public int[] findRedundantConnection(int[][] edges) {
        int N = 0;
        for (int[] edge : edges) {
            N = Math.max(N, Math.max(edge[0], edge[1]));
        }
        int[] parent = new int[N + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; // Each vertex is a component
        }
        int[] size = new int[N + 1];
        Arrays.fill(size, 1);
        int[] ans = null;
        for (int[] edge : edges) {
            int p0 = findParent(parent, edge[0]);
            int p1 = findParent(parent, edge[1]);
            // We keep iterating the whole of edge array to assign ans with the last
            // redundant edge
            if (p0 != p1) {
                // this is a NOT a redundant edge. Perform unioun operation
                unify(parent, size, p0, p1);
            } else {
                ans = edge;
            }
        }
        return ans;
    }

    private int findParent(int[] parent, int vertex) {
        int rootVertex = vertex;
        while (parent[rootVertex] != rootVertex) {
            rootVertex = parent[rootVertex];
        }
        // Path compression implementation
        while (vertex != rootVertex) {
            int next = parent[vertex];
            parent[vertex] = rootVertex;
            vertex = next;
        }
        return rootVertex;
    }

    // Weighted unioun find ; so that the tree structures remain mostly flat
    private void unify(int[] parent, int[] size, int p0, int p1) {
        if (size[p0] < size[p1]) {
            parent[p0] = p1;
            size[p1] += size[p0];
        } else {
            // Assign p0 as the root.
            parent[p1] = p0;
            // Increase the size of the root with the new set that has been unified
            size[p0] += size[p1];
        }
    }
}

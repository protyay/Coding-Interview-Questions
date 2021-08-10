import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsSubSeq_LC128 {
    public int longestConsecutive(int[] nums) {
        int N = nums.length;
        UnionFind uf = new UnionFind(N);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(nums[i]))
                continue;
            if (map.containsKey(nums[i] + 1))
                uf.unite(i, map.get(nums[i] + 1));
            if (map.containsKey(nums[i] - 1))
                uf.unite(i, map.get(nums[i] - 1));
            map.put(nums[i], i);
        }
        return uf.findLargestComp();
    }

    public static void main(String[] args) {
        int[] arr = { 9, -1, 4, -9, -3, 0, -8, 2, 6, -4, -3, 4, 1, 3, 5, 5, -7, -7, 1, -9, -3, 3, 8, 4, 1, 2 };
        Arrays.sort(arr);
        LongestConsSubSeq_LC128 lc128 = new LongestConsSubSeq_LC128();
        int longestConsecutive = lc128.longestConsecutive(arr);
        System.out.println("longest = " + longestConsecutive);
    }
}

class UnionFind {
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

}
/**
 * https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/datastructures/unionfind/UnionFind.java
 */

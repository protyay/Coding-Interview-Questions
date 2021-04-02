import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MinHeightTrees_LC310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Because leaf nodes has degree 1, we keep removing those
        // Apply Kahn's Algo
        // if(edges.length == 0) return List.of();
        if (n == 1)
            return List.of(0);
        if (n == 2)
            return List.of(0, 1);
        int[] deg = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            deg[edge[0]]++;
            deg[edge[1]]++;

            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1)
                queue.addLast(i);
        }
        while (n > 2) {
            int size = queue.size();
            n -= size;
            while (size-- > 0) {
                int top = queue.removeFirst();
                List<Integer> neighbours = adjList.get(top);
                for (int vertex : neighbours) {
                    deg[vertex]--;
                    if (deg[vertex] == 1)
                        queue.addLast(vertex);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        res.addAll(queue);

        return res;
    }
}

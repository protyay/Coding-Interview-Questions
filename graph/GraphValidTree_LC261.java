import java.util.ArrayList;
import java.util.List;

public class GraphValidTree_LC261 {
    // SDE Graph - Very important problem
    public boolean validTree(int n, int[][] edges) {
        // Build adj list from the edges
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        // Traverse the Graph in a DFS manner
        boolean[] visited = new boolean[n];
        int comp = 0;

        // Detecting cycle in an undirected graph
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ++comp;
                if (hasCycle(adjList, i, visited, -1))
                    return false;
            }
        }
        if (comp > 1)
            return false;
        return true;
    }

    private boolean hasCycle(List<List<Integer>> adjList, int start, boolean[] visited, int parent) {
        if (visited[start])
            return true;

        visited[start] = true;

        List<Integer> neighbours = adjList.get(start);
        for (int n : neighbours) {
            if (parent == n)
                continue;

            if (hasCycle(adjList, n, visited, start))
                return true;
        }
        return false;
    }
}
/**
 * Understand the cycle constraint and the component constraint
 * The graph should be connected as well as there should be NO cycle.
 */
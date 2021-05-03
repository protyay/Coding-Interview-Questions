import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumOfComp_UG_LC323 {
    // SDE problem
    public int countComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> edgeMap = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            edgeMap.computeIfAbsent(from, k -> new ArrayList<>());
            edgeMap.computeIfAbsent(to, k -> new ArrayList<>());

            edgeMap.get(from).add(to);
            edgeMap.get(to).add(from);
        }
        boolean[] visited = new boolean[n];
        int comp = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ++comp;
                dfs(i, visited, edgeMap);
            }
        }
        return comp;
    }

    private void dfs(int v, boolean[] visited, Map<Integer, List<Integer>> edges) {
        visited[v] = true;
        List<Integer> neighbours = edges.getOrDefault(v, new ArrayList<>());
        for (int edge : neighbours) {
            if (visited[edge])
                continue;
            dfs(edge, visited, edges);
        }
    }

    public static void main(String[] args) {
        NumOfComp_UG_LC323 lc323 = new NumOfComp_UG_LC323();
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        int comp = lc323.countComponents(3, edges);
        System.out.println("Total comp =" + comp);
    }
}
/**
 * One most important point is to understand that the edge map in an undirected graph
 * will contain two mappings for a given edge. This is very important.
 */

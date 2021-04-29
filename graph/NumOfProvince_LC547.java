public class NumOfProvince_LC547 {
    public int findCircleNum(int[][] adjM) {
        // Given an adjacency matrix, calculate the graph components
        int n = adjM.length; // Total vertices
        boolean[] visited = new boolean[n + 1]; // Because V Starts from 1
        int province = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                ++province;
                DFS(adjM, visited, i);
            }
        }
        return province;
    }

    private void DFS(int[][] adjM, boolean[] visited, int nextCity) {
        visited[nextCity] = true;
        int[] neighbours = adjM[nextCity - 1];
        for (int i = 1; i <= neighbours.length; i++) {
            if (visited[i])
                continue;
            if (neighbours[i - 1] == 1)
                DFS(adjM, visited, i);
        }
    }
}
/**
 * Take explicit care in graph problems where vertices start at 1
 */
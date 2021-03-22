public class FriendsGroup_BS150 {
    public int solve(int[][] friends) {
        boolean[] visited = new boolean[friends.length];
        int groups = 0;
        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                ++groups;
                dfs(i, friends, visited);
            }
        }
        return groups;
    }
    private void dfs(int start, int[][] adjList, boolean[] visited) {
        visited[start] = true;
        int[] neighbours = adjList[start];
        for (int i = 0; i < neighbours.length; i++) {
            if (visited[neighbours[i]])
                continue;
            dfs(neighbours[i], adjList, visited);
        }
    }
}

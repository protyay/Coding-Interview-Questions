public class NumberOfIslands_LC200 {
    private final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        // Count the num of components in the graph
        int r = grid.length, c = grid[0].length;
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    ++ans;
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        for (int[] dir : DIRS) {
            int dx = i + dir[0];
            int dy = j + dir[1];

            if (!inMatrix(dx, dy, grid) || grid[dx][dy] == '0')
                continue;
            dfs(dx, dy, grid);
        }
    }

    private boolean inMatrix(int x, int y, char[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return false;
        return true;
    }
}

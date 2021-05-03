public class MaxAreaOfIsland_LC695 {
    private int M;
    private int N;
    private final int[][] adj = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private int maxArea = 0, currArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        this.M = grid.length;
        this.N = grid[0].length;

        boolean[][] visited = new boolean[this.M][this.N];

        for (int i = 0; i < this.M; i++) {
            for (int j = 0; j < this.N; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                    maxArea = Math.max(currArea, maxArea);
                    currArea = 0;
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if (!isInMatrix(x, y) || grid[x][y] == 0 || visited[x][y])
            return;

        visited[x][y] = true;
        ++currArea;

        for (int[] cell : this.adj) {
            int nextX = x + cell[0];
            int nextY = y + cell[1];

            dfs(grid, nextX, nextY, visited);
        }
    }

    private boolean isInMatrix(int r, int c) {
        if (r < 0 || r >= this.M || c < 0 || c >= this.N)
            return false;
        return true;
    }
}

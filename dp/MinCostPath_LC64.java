public class MinCostPath_LC64 {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        // Initialize all default grid values to -1; This can be modified if the problem
        // constraints allows -1 as VALID value.
        int[][] memo = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                memo[i][j] = -1;
            }
        }
        return minCostPath(grid, 0, 0, memo);
    }

    /**
     * Accepts a 2D grid which memoized intermediate results
     * 
     * @param grid
     * @param r
     * @param c
     * @param memo
     * @return
     */
    private int minCostPath(int[][] grid, int r, int c, int[][] memo) {

        if (r < 0 || r == grid.length || c < 0 || c == grid[0].length)
            return Integer.MAX_VALUE;
        else if (r == grid.length - 1 && c == grid[0].length - 1)
            return grid[r][c];
        else if (memo[r][c] > -1)
            return memo[r][c];

        int right = minCostPath(grid, r, c + 1, memo);
        int down = minCostPath(grid, r + 1, c, memo);
        memo[r][c] = grid[r][c] + Math.min(right, down);
        return memo[r][c];
    }

    public static void main(String[] args) {
        MinCostPath_LC64 lc64 = new MinCostPath_LC64();
        int[][] input = { { 1, 3 }, { 1, 5 } };
        int cost = lc64.minPathSum(input);
        System.out.println("Cost = " + cost);
    }
}

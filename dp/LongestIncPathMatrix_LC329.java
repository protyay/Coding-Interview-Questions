public class LongestIncPathMatrix_LC329 {
    private final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private int row = 0, col = 0;
    private Integer[][] dp;
    private boolean[][] visited;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        this.row = matrix.length;
        this.col = matrix[0].length;
        int max = 0;
        this.dp = new Integer[this.row][this.col];
        this.visited = new boolean[this.row][this.col];

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                max = Math.max(max, dfs(i, j, matrix));
            }
        }
        return max;
    }

    private int dfs(int row, int col, int[][] matrix) {
        if (dp[row][col] != null)
            return dp[row][col];
        int currMax = 0;
        visited[row][col] = true;
        for (int[] d : DIRECTIONS) {
            int dx = d[0] + row;
            int dy = d[1] + col;

            if (!isInMatrix(dx, dy) || visited[dx][dy] || matrix[dx][dy] <= matrix[row][col])
                continue;
            currMax = Math.max(currMax, dfs(dx, dy, matrix));
        }
        visited[row][col] = false;
        return dp[row][col] = currMax + 1;
    }

    private boolean isInMatrix(int row, int col) {
        if (row < 0 || row >= this.row || col < 0 || col >= this.col)
            return false;
        return true;
    }
}

/**
 * Understand this is very similar to Longest Increasing Subsequence problem
 * O(N*M)
 */


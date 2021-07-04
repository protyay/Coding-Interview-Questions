public class LongestIncPathMatrix_LC329 {
    int row = 0;
    int col = 0;
    final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private final Integer[][] dp = new Integer[201][201];

    // SDE
    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;
        int maxLen = 0;
        this.row = matrix.length;
        this.col = matrix[0].length;

        boolean[][] visited = new boolean[this.row][this.col];

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, visited, -1));
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int r, int c, boolean[][] visited, int prev) {
        if (!isInMatrix(r, c) || visited[r][c])
            return 0;
        if (prev != -1 && matrix[r][c] <= prev)
            return 0;
        if (dp[r][c] != null)
            return dp[r][c];
        visited[r][c] = true;
        int max = 0;
        for (int[] dir : dirs) {
            int dx = dir[0] + r;
            int dy = dir[1] + c;

            max = Math.max(max, 1 + dfs(matrix, dx, dy, visited, matrix[r][c]));
            dp[r][c] = max;
            visited[r][c] = false;
        }
        return max;
    }

    private boolean isInMatrix(int dx, int dy) {
        if (dx < 0 || dx >= this.row || dy < 0 || dy >= this.col)
            return false;
        return true;
    }
}

/**
 * Understand this is very similar to Longest Increasing Subsequence problem
 */
class LongestIncreasingPath_BottomUp {

}

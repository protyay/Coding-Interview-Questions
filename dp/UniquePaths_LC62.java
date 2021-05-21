public class UniquePaths_LC62 {
    // SDE - Brute Force Repeat
    public int uniquePaths(int m, int n) {
        int i = 0, j = 0;
        int[][] dp = new int[m + 1][n + 1];
        return calc(i, j, m, n, dp);
    }

    private int calc(int i, int j, int m, int n, int[][] dp) {
        if (i == m - 1 && j == n - 1)
            return 1;
        if (dp[i][j] > 0)
            return dp[i][j];
        if (i >= m || j >= n)
            return 0;

        int sum = calc(i + 1, j, m, n, dp) + calc(i, j + 1, m, n, dp);
        dp[i][j] = sum;
        return sum;
    }
}
/**
 * TC - O(N*M)
 */

import java.util.Arrays;

public class LongestCommonSubsequence_LC1143 {
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0)
            return 0;
        int m = A.length(), n = B.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (A.charAt(i) == B.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }

    public static void main(String[] args) {
        String a = "abd", b = "ad";
        LongestCommonSubsequence_LC1143 lc1143 = new LongestCommonSubsequence_LC1143();
        int lcs = lc1143.longestCommonSubsequence(a, b);
        System.out.println("LCS = " + lcs);
    }
}

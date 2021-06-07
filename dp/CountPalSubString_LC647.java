public class CountPalSubString_LC647 {
    // SDE problem
    public int countSubstrings(String s) {
        if (s == null || s.isBlank())
            return 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        // Define the base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ++ans;
        }
        for (int end = 1; end < n; end++) {
            for (int start = 0; start < end; start++) {
                boolean isPal = s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1]);

                if (isPal)
                    ++ans;
                dp[start][end] = isPal;
            }
        }
        return ans;
    }

}

class PalSubstr_SpaceOptimized {
    public int countSubstrings(String s) {
        int count = 0;
        char[] c = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            count += expand(i, i, c);
            count += expand(i, i + 1, c);
        }
        return count;
    }

    private int expand(int s, int e, char[] str) {
        int c = 0;
        while (s >= 0 && e < str.length && str[s] == str[e]) {
            s--;
            e++;
            c++;
        }
        return c;
    }
}

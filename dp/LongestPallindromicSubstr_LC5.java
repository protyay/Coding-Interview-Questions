public class LongestPallindromicSubstr_LC5 {
    // SDE 
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1)
            return s;

        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        int subStart = 0, subEnd = 0, maxLen = 0;
        // Initialize the DP array
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        // Generate all substring - start, end
        //
        for (int end = 1; end < s.length(); end++) {
            for (int start = 0; start < end; start++) {
                // Generate all substring
                dp[start][end] = end - start + 1 > 2 ? s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1]
                        : s.charAt(start) == s.charAt(end);
                if (dp[start][end] && end - start + 1 > maxLen) {
                    maxLen = end - start + 1;
                    subStart = start;
                    subEnd = end;
                }
            }
        }
        if (maxLen == 0)
            return Character.toString(s.charAt(0));
        String ans = s.substring(subStart, subEnd + 1);
        return ans;
    }
}

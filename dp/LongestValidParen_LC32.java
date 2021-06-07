public class LongestValidParen_LC32 {
    // SDE problem
    public int longestValidParentheses(String s) {
        if (s == null || s.isBlank())
            return 0;
        s = " " + s;
        int[] dp = new int[s.length()];
        char[] c = s.toCharArray();
        int maxLen = 0;

        for (int i = 1; i < c.length; i++) {
            if (c[i] == ')') {
                if (c[i - 1] == '(')
                    dp[i] = dp[i - 2] + 2;
                else if (c[i - dp[i - 1] - 1] == '(')
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}

class StackSolution {
    public int longestValidParentheses(String s) {
        if (s == null || s.isBlank())
            return 0;
        int l = 0, r = 0;
        int maxLen = 0;

        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(')
                ++l;
            else
                ++r;
            if (l == r)
                maxLen = Math.max(maxLen, 2 * l);
            else if (r > l)
                l = r = 0;
        }
        l = r = 0;
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] == '(')
                ++l;
            else
                ++r;
            if (l == r)
                maxLen = Math.max(maxLen, 2 * l);
            else if (l > r)
                l = r = 0;
        }
        return maxLen;
    }
}

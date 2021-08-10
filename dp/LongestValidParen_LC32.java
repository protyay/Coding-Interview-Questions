public class LongestValidParen_LC32 {
    // SDE problem
    public int longestValidParentheses(String s) {
        // we go from left to right
        int open = 0, close = 0;
        int maxLen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(')
                open++;
            else
                close++;

            if (open == close)
                maxLen = Math.max(maxLen, open * 2);
            else if (close > open)
                open = close = 0;
        }
        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(')
                open++;
            else
                close++;

            if (open == close)
                maxLen = Math.max(maxLen, open * 2);
            else if (open > close)
                open = close = 0;
        }
        return maxLen;
    }
}

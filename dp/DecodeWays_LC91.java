public class DecodeWays_LC91 {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty())
            return 0;
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        Integer[] memo = new Integer[101];
        int ans = dfs(0, s, memo);
        return ans;
    }

    private int dfs(int idx, String s, Integer[] memo) {
        // Left and right branch base-case scenario
        if (idx >= s.length())
            return 1;
        if (memo[idx] != null)
            return memo[idx];
        if (s.charAt(idx) == '0')
            return 0;

        int ans = dfs(idx + 1, s, memo);
        // Two characters decoding scenario is VALID only if we are at last but one
        // character or before
        if (idx + 2 <= s.length()) {
            int value = Integer.parseInt(s.substring(idx, idx + 2));
            if (value <= 26) {
                ans += dfs(idx + 2, s, memo);
            }
        }
        memo[idx] = ans;
        return ans;
    }

    public static void main(String[] args) {
        DecodeWays_LC91 lc91 = new DecodeWays_LC91();
        int ans = lc91.numDecodings("123");
        System.out.println("Ans is =" + ans);
    }
}

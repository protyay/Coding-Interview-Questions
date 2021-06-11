import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_LC139 {
    // SDE
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }
        return dfs(dict, s);
    }

    private boolean dfs(Set<String> dict, String s) {
        if (s.isEmpty())
            return true;
        char[] ch = s.toCharArray();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < ch.length; i++) {
            str.append(ch[i]);

            if (!dict.contains(str.toString()))
                continue;
            if (dfs(dict, s.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }
    // TC - O(N^2)
    // SC - O(N)
    class Solution_TopDownWithMemoization {
        public boolean wordBreak(String s, List<String> wordDict) {

            Boolean[] dp = new Boolean[s.length()];
            return dfs(new HashSet<>(wordDict), s, 0, dp);
        }

        private boolean dfs(Set<String> dict, String s, int start, Boolean[] dp) {
            if (s.length() == start)
                return true;
            if (dp[start] != null)
                return dp[start];

            char[] ch = s.toCharArray();
            StringBuilder str = new StringBuilder();

            for (int i = start; i < ch.length; i++) {
                str.append(ch[i]);
                if (!dict.contains(str.toString()))
                    continue;
                if (dfs(dict, s, i + 1, dp))
                    return dp[start] = true;
            }
            return dp[start] = false;
        }
    }

    public boolean wordBreak_dp(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak_LC139 lc139 = new WordBreak_LC139();
        String s = "leetcode";
        // String s = "applepenapple";
        List<String> wordDict = Arrays.asList("leet", "code");
        // List<String> wordDict = Arrays.asList("apple", "pen");
        boolean wordBreak = lc139.wordBreak_dp(s, wordDict);
        System.out.println("Word break =" + wordBreak);
    }
}
/**
 * This DP problem is very similar to Min. difficulty in Job scheduling - LC1335
 */

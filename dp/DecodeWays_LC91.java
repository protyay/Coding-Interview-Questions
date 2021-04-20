public class DecodeWays_LC91 {
    /**
     * This also appears 
     */
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
/**
 * This is the solution for Binary Search problem 8 - Decode Message
 */
class Solution {
    public int solve(String message) {
        if (message.isEmpty())
            return 0;
        // Any 1 length string can be decoded in 1 way
        if (message.length() == 1)
            return 1;
        int[] memo = new int[message.length()];
        Arrays.fill(memo, -1);
        int way = decode(message, 0, memo);
        return way;
    }
    private int decode(String message, int index, int[] memo) {
        // We might end up with an index equal to the string length, if we have considered two char
        // string
        if (index == message.length())
            return 1;

        // Cannot start any decoding with zero
        if (message.charAt(index) == '0')
            return 0;

        // If we are at the last index and WE DIDN'T violate any constraint, we have a valid
        // decoding
        if (index == message.length() - 1)
            return 1;

        if (memo[index] > -1)
            return memo[index];

        // We add 1 because it DOESN'T violates any invariant
        int one = decode(message, index + 1, memo);
        int two = 0;
        if (index + 2 <= message.length()) {
            int numValue = Integer.parseInt(message.substring(index, index + 2));
            if (numValue > 0 && numValue <= 26)
                two = decode(message, index + 2, memo);
        }
        memo[index] = one + two;
        return memo[index];
    }
}
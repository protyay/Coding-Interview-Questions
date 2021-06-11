public class LongestSubStrWithoutRepeatingChars_LC3 {
    // SDE
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s == null)
            return max;
        int[] hash = new int[129];
        char[] ch = s.toCharArray();
        int l = 0, r = 0;
        for (; r < ch.length; r++) {
            while (hash[ch[r]] + 1 > 1) {
                hash[ch[l++]]--;
            }
            hash[ch[r]]++;
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
/**
 * One of the classic Two Pointer problems involving string
 * Remember to use a char array to handle special char and space scenario
 * instead of hash based DS
 */

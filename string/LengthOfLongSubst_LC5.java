public class LengthOfLongSubst_LC5 {
    public int lengthOfLongestSubstring(String s) {
        // Longest substring with 0 repeating characters
        if (s.length() < 1)
            return s.length();

        int[] freq = new int[129];
        char[] ch = s.toCharArray();
        int maxLen = 0;

        for (int l = 0, r = 0; r < ch.length; r++) {
            // If we've already seen the current char
            if (freq[ch[r]] > 0) {
                // adjust the window
                while (l < r) {
                    if (ch[l] == ch[r]) {
                        freq[ch[l++]]--;
                        break;
                    }
                    freq[ch[l++]]--;
                }
                freq[ch[r]]++;
            } else {
                freq[ch[r]]++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongSubst_LC5 lc5 = new LengthOfLongSubst_LC5();
        int ans = lc5.lengthOfLongestSubstring("abcabcbb");
        System.out.println("Maximum length = " + ans);
    }
}

/**
 * If we encounter a previously seen character, adjust the window, and then
 * include the current character count
 */

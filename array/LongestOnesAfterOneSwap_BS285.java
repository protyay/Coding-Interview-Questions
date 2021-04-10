public class LongestOnesAfterOneSwap_BS285 {
    public int solve(String s) {
        if (s.isEmpty())
            return 0;
        if (s.length() == 1)
            return s.charAt(0) == '0' ? 0 : 1;
        // We would want to identify the longest substring with one zero
        char[] ch = s.toCharArray();
        int maxOneLen = 0, oneCount = 0, zeroCount = 0;
        // 011101100
        // 11111000
        // 0111011101
        // 0011

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1')
                ++oneCount;
        }
        for (int i = 0, j = 0; j < ch.length; j++) {
            if (ch[j] == '0')
                ++zeroCount;
            if (zeroCount == 2) {
                // Be very critical of adjustment of left pointers
                while (i < ch.length) {
                    if (ch[i++] == '0') {
                        --zeroCount;
                        break;
                    }

                }
            }
            maxOneLen = Math.max(maxOneLen, j - i + 1);
            // Special invariant - If we hit a scenario wherein we have already included
            // all available ones in the string, then we simply break early and return
            if (zeroCount > 0 && maxOneLen - zeroCount >= oneCount) {
                return maxOneLen - 1;
            }
        }
        return maxOneLen;
    }
}
/**
 * This follows the typical two-pointer sliding window appraoch
 * 
 * Points to take care of - Be very critical while adjusting left pointers
 * because we are restoring the invariant here before we proceed any further.
 * 
 * When to trigger the pointer adjustment ? In this case - because we want max
 * consecutive ones, if we encounter consecutive zero, we immediately adjust the
 * left pointer to restore 1 zero
 * 
 * 
 */

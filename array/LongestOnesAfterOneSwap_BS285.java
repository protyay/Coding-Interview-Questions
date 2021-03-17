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
            if (zeroCount > 0 && maxOneLen - zeroCount >= oneCount) {
                return maxOneLen - 1;
            }
        }
        return maxOneLen;
    }
}

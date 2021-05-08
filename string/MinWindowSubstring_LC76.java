public class MinWindowSubstring_LC76 {
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
            return "";

        int[] freqS = new int[128];
        int[] freqT = new int[128];

        for (int i = 0; i < t.length(); i++) {
            freqT[t.charAt(i) - 'A']++;
        }
        int seenChar = 0;
        char[] ch = s.toCharArray();
        int l = 0, startIdx = 0, endIdx = 0, maxLen = Integer.MAX_VALUE;

        for (int i = 0; i < ch.length; i++) {

            if (freqT[ch[i] - 'A'] > 0) {

                freqS[ch[i] - 'A']++;
                if (freqS[ch[i] - 'A'] <= freqT[ch[i] - 'A'])
                    ++seenChar;
            }
            while (seenChar == t.length() && l <= i) {
                if (freqT[ch[l] - 'A'] > 0) {
                    if (freqS[ch[l] - 'A'] == freqT[ch[l] - 'A']) {
                        --seenChar;
                    }
                    freqS[ch[l] - 'A']--;
                }
                if (i - l + 1 < maxLen) {
                    startIdx = l;
                    endIdx = i;
                    maxLen = i - l + 1;
                }
                ++l;
            }
        }
        if (maxLen == Integer.MAX_VALUE)
            return "";
        String res = s.substring(startIdx, endIdx + 1);
        return res;
    }

    public static void main(String[] args) {
        MinWindowSubstring_LC76 lc76 = new MinWindowSubstring_LC76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = lc76.minWindow(s, t);
        System.out.println("Ans = " + ans);
    }
}
/**
 * The invariant of the problem lies in the fact that we can update the result
 * ONLY when we have ATLEAST ALL OF THE CHARS THAT WE NEED. Which means, it's
 * very crucial how we maintain the invariant during the sliding operation.
 */
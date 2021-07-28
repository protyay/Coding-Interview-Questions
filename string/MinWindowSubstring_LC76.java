public class MinWindowSubstring_LC76 {
    public String minWindow(String s, String t) {
        int[] ss = new int[256];
        int[] tt = new int[256];
        for (char c : t.toCharArray()) {
            tt[c]++;
        }
        int seen = 0, len = Integer.MAX_VALUE;
        char[] ch = s.toCharArray();
        int start = 0, end = 0;
        // We need to figure out if a character is present in t and also the
        // corresponding
        // count of it.
        for (int l = 0, r = 0; r < s.length(); r++) {
            char curr = ch[r];
            if (ss[curr] < tt[curr]) {
                ++seen;
            }
            ss[curr]++;
            while (seen == t.length()) {
                // We contract the window
                if (r - l + 1 < len) {
                    start = l;
                    end = r;
                    len = r - l + 1;
                }
                if (ss[ch[l]] - 1 < tt[ch[l]]) {
                    --seen;
                }
                ss[ch[l]]--;
                l++;
            }
        }
        if (len == Integer.MAX_VALUE)
            return "";

        String ans = s.substring(start, end + 1);
        return ans;
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
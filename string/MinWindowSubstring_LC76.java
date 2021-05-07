import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring_LC76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }
        // Fix l = 0; Traverse till we cover each element from t, with equal count
        // Record the size of the window.
        // Keep moving l till until the window becomes invalid. Character or their
        // freq is NOT equal to T
        int l = 0, len = Integer.MAX_VALUE;
        StringBuilder str = new StringBuilder();
        String res = "";
        char[] ch = s.toCharArray();
        for (int r = 0; r < ch.length; r++) {
            if (tCount.containsKey(ch[r])) {
                // 1. sCount contains this every occurence of this character
                // 2. Doesn't contain this char
                // 3. Contains the char but not all occurence
                if (sCount.getOrDefault(ch[r], 0) < tCount.get(ch[r])) {
                    sCount.put(ch[r], sCount.getOrDefault(ch[r], 0) + 1);
                }
            }
            str.append(ch[r]);
            int currentLen = r - l + 1;
            // How do we recognize that the current window len is valid ?
            if (isValidWindow(tCount, sCount)) {

                // Record the valid substring and the length for further reference
                if (currentLen < len) {
                    res = str.toString();
                    len = currentLen;
                }
                // Keep moving l till the window becomes invalid
                while (l < r && isValidWindow(tCount, sCount)) {
                    if (!sCount.containsKey(ch[l]))
                        continue;

                    sCount.put(ch[l], sCount.get(ch[l]) - 1);
                    if (sCount.get(ch[l]) == 0)
                        sCount.remove(ch[l]);
                    l++;
                }
                str.delete(0, str.length() - 1);
                str.append(s.substring(l, r + 1));
            }
        }
        return res;
    }

    private boolean isValidWindow(Map<Character, Integer> t, Map<Character, Integer> s) {
        if (t.size() != s.size())
            return false;
        for (char c : t.keySet()) {
            if (!s.containsKey(c) || s.get(c) != t.get(c))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MinWindowSubstring_LC76 lc76 = new MinWindowSubstring_LC76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = lc76.minWindow(s, t);
        System.out.println("Ans = " + ans);
    }
}

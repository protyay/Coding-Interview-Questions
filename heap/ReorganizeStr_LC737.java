import java.util.*;
public class ReorganizeStr_LC737 {
    public String reorganizeString(String S) {
        Map<Character, Integer> chFreq = new HashMap<>();
        char[] ch = S.toCharArray();
        int N = S.length();
        int maxPermissible = (int) Math.ceil(N / 2.0d);

        for (int i = 0; i < S.length(); i++) {
            int freq = chFreq.getOrDefault(ch[i], 0) + 1;
            if (freq > maxPermissible)
                return "";
            chFreq.put(ch[i], freq);
        }
        // Build a string with the given freq such that the same characters
        // doesn't appear consecutively
        for (int i = 0; i < ch.length; i++) {

            for (char c = 'a'; c <= 'z'; c++) {

                if (chFreq.containsKey(c) && chFreq.get(c) > 0) {
                    if (i > 0 && c == ch[i - 1])
                        continue;
                    ch[i] = c;
                    chFreq.put(c, chFreq.get(c) - 1);
                    if (chFreq.get(c) == 0)
                        chFreq.remove(c);
                    break;
                }
            }
        }
        return new String(ch);
    }

}

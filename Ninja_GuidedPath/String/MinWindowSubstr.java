package String;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindowSubstr {

    public static String shortestSubstring(String s) {
        // Write your code here.
        if (s == null || s.length() == 1)
            return s;
        char[] c = s.toCharArray();
        Set<Character> unique = new HashSet<>();
        for (int i = 0; i < c.length; i++) {
            unique.add(c[i]);
        }
        Map<Character, Integer> currWindow = new HashMap<>();
        int l = 0, r = 0, len = s.length() + 1, start = 0, end = 0;
        for (; r < c.length; r++) {
            currWindow.put(c[r], currWindow.getOrDefault(c[r], 0) + 1);

            while (currWindow.keySet().size() == unique.size()) {
                int windowSize = r - l + 1;
                if (windowSize < len) {
                    len = windowSize;
                    start = l;
                    end = r;
                }
                int freq = currWindow.get(c[l]);
                if (freq - 1 == 0)
                    currWindow.remove(c[l]);
                else
                    currWindow.put(c[l], freq - 1);
                l++;
            }
        }
        String ans = s.substring(start, end + 1);
        return ans;

    }
}

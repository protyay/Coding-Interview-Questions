import java.util.*;

public class KRepeatedSubstr_BS618 {
    public int solve(String s, int k) {
        // K Min value is 1.
        if (s.isEmpty() || s.length() == 1)
            return 0;
        Map<String, Integer> freq = new HashMap<>();
        StringBuilder ssBuilder = new StringBuilder();
        char[] ch = s.toCharArray();
        for (int i = 0, j = 0; i <= ch.length - k; i++) {
            while (j < ch.length && j - i + 1 <= k) {
                ssBuilder.append(ch[j]);
                if (j - i + 1 == k) {
                    String ss = ssBuilder.toString();
                    freq.computeIfAbsent(ss, a -> 0);
                    freq.put(ss, freq.get(ss) + 1);
                }
                ++j;
            }
            ssBuilder.deleteCharAt(0);
        }
        int res = 0;
        for (Map.Entry<String, Integer> pair : freq.entrySet()) {
            if (pair.getValue() > 1)
                ++res;
        }
        return res;
    }

    public static void main(String[] args) {
        KRepeatedSubstr_BS618 bs = new KRepeatedSubstr_BS618();
        String s = "aaabbb";
        int solve = bs.solve(s, 2);
        System.out.println(solve);
    }

}

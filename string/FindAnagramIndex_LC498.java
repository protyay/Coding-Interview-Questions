import java.util.*;

public class FindAnagramIndex_LC498 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.isEmpty())
            return List.of();
        List<Integer> indices = new ArrayList<>();
        int[] dictP = new int[26], dictS = new int[26];
        for (char c : p.toCharArray()) {
            dictP[c - 'a']++;
        }
        int pLen = p.length();
        // Sliding window approach 
        for (int i = 0, j = 0; i < s.length(); i++) {
            while (j < s.length() && j - i + 1 <= pLen) {
                dictS[s.charAt(j) - 'a']++;
                j++;
            }
            if (Arrays.equals(dictP, dictS))
                indices.add(i);
            dictS[s.charAt(i) - 'a']--;
        }
        return indices;
    }

}

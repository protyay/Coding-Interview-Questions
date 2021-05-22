import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAndRepPattern_LC890 {
    // SDE 
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        // Build bijection for each string
        // ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
        int[] pMap = new int[26];

        List<String> ans = new ArrayList<>();
        for (String word : words) {
            pMap = new int[26];
            Arrays.fill(pMap, -1);
            char[] ch = word.toCharArray();
            boolean isValid = true;

            int[] curr = new int[26];
            Arrays.fill(curr, -1);
            for (int i = 0; i < ch.length; i++) {
                // Curr char mapping

                int currPatternCh = pattern.charAt(i) - 'a';
                int currWordCh = ch[i] - 'a';

                // Check curr-map pattern
                if (curr[currWordCh] == -1)
                    curr[currWordCh] = currPatternCh;
                else {
                    if (curr[currWordCh] != currPatternCh) {
                        isValid = false;
                        break;
                    }
                }
                // Verify pattern map
                if (pMap[currPatternCh] == -1)
                    pMap[currPatternCh] = currWordCh;
                else {
                    if (pMap[currPatternCh] != currWordCh) {
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid)
                ans.add(word);
        }
        return ans;
    }
}

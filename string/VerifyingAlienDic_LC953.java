import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDic_LC953 {
    // SDE problem
    private Map<Character, Integer> weight;

    public boolean isAlienSorted(String[] words, String order) {
        if (order == null || words == null || words.length == 0)
            return false;
        weight = new HashMap<>();
        // Go through the order and build the weightage of each char
        int w = 0;
        for (char c : order.toCharArray()) {
            weight.put(c, w++);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (lexOrder(words[i], words[i + 1]) > 0)
                return false;
        }
        return true;
    }

    public int lexOrder(String a, String b) {
        // chk // cfggk
        // chk // chka
        // For lex order, we check both char at the same index.
        // Possible outcomes -
        // A. weight[chA] == weight[chB], we go to the next index;
        // B. weight[chA] != weight[chB], then return 0, if weight[chA] < weight[chB]
        // else 1;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            int wA = weight.get(a.charAt(i));
            int wB = weight.get(b.charAt(i));
            if (wA != wB && wA < wB)
                return 0;// early exit
            if (wA > wB)
                return 1;
            ++i;
            ++j;
        }
        // If we have more chars in A to be checked than B, we return false
        if (i != a.length())
            return 1;
        return 0;
    }

}
/**
 * Very good problem to test you really understand what lexicographic means If
 * at the first differing character, the left string has a char with less weight
 * than the right string, it is lexicographically sorted
 */
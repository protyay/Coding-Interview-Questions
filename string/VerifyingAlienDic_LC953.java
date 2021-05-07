import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDic_LC953 {
    // SDE problem
    public boolean isAlienSorted(String[] words, String order) {
        final Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (this.compare(words[i], words[i + 1], indexMap) > 0)
                return false;
        }
        return true;
    }

    public int compare(String a, String b, Map<Character, Integer> indexMap) {
        int indexA = 0, indexB = 0;
        while (indexA < a.length() && indexB < b.length()) {
            int pa = indexMap.get(a.charAt(indexA));
            int pb = indexMap.get(b.charAt(indexB));
            if (pa > pb)
                return 1;
            else if (pa < pb)
                return -1;
            ++indexA;
            ++indexB;
        }
        if (a.length() > b.length())
            return 1;
        return 0;
    }
}
/**
 * Very good problem to test you really understand what lexicographic means
 * If at the first differing character, the left string has a char with less weight than the right string, 
 * it is lexicographically sorted
 */
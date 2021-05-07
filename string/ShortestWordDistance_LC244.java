import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// SDE problem
public class ShortestWordDistance_LC244 {
    private final Map<String, List<Integer>> index;

    public ShortestWordDistance_LC244(String[] wordsDict) {
        this.index = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            index.computeIfAbsent(wordsDict[i], k -> new ArrayList<Integer>());
            index.get(wordsDict[i]).add(i);
        }
    }
    // 3 5 8 12
    // 1 9

    public int shortest(String word1, String word2) {
        List<Integer> indexA = this.index.get(word1);
        List<Integer> indexB = this.index.get(word2);

        int iA = 0, iB = 0;
        int min = Integer.MAX_VALUE;
        while (iA < indexA.size() && iB < indexB.size()) {
            min = Math.min(min, Math.abs(indexA.get(iA) - indexB.get(iB)));
            if (indexA.get(iA) > indexB.get(iB)) {
                iB++;
            } else {
                iA++;
            }
        }
        return min;
    }
}

import java.util.*;

public class TopKFreqWords_LC692 {
    public List<String> topKFrequent(String[] words, int k) {
        // SC - O(N)
        Map<String, Integer> strCount = new HashMap<>();
        Comparator<String> freqCompare = (a, b) -> strCount.get(b) - strCount.get(a);
        Comparator<String> lexComparator = freqCompare.thenComparing(Comparator.naturalOrder());
        Queue<String> fStrings = new PriorityQueue<>(k, lexComparator);
        // TC - O(N)
        for (String w : words) {
            strCount.put(w, strCount.getOrDefault(w, 0) + 1);
        }
        // TC - O(N LOG K) operation
        fStrings.addAll(strCount.keySet());
        // SC - O(K) Space
        List<String> ans = new ArrayList<>();
        // TC - O(K)
        while (!fStrings.isEmpty() && k-- > 0) {
            ans.add(fStrings.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        TopKFreqWords_LC692 lc347 = new TopKFreqWords_LC692();
        String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
        final List<String> res = lc347.topKFrequent(words, 2);
        System.out.println(res);
    }

}

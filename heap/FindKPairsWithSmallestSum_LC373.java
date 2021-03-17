import java.util.*;

public class FindKPairsWithSmallestSum_LC373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<Entry> sum = new PriorityQueue<>((a, b) -> Integer.compare(b.sum, a.sum));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                Entry a = new Entry(Arrays.asList(nums1[i], nums2[j]), nums1[i] + nums2[j]);
                if (sum.size() == k) {
                    if (a.sum < sum.peek().sum) {
                        sum.poll();
                        sum.add(a);
                    }
                } else
                    sum.add(a);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!sum.isEmpty()) {
            ans.add(sum.poll().pair);
        }
        return ans;
    }
}

class Entry {
    List<Integer> pair;
    int sum;

    Entry(List<Integer> pair, int sum) {
        this.pair = pair;
        this.sum = sum;
    }
}

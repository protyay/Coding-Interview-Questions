import java.util.*;

public class TopKFreqElements_LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        Queue<ArrayEntry> q = new PriorityQueue<>((a, b) -> Integer.compare(a.freq, b.freq));
        // O(N) SC
        Map<Integer, Integer> freq = new HashMap<>();
        // O(N) complexity
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        // O(NlogK)
        for (Map.Entry<Integer, Integer> pair : freq.entrySet()) {
            if (q.size() == k) {
                if (q.peek().freq < pair.getValue()) {
                    q.poll();
                    q.add(new ArrayEntry(pair.getValue(), pair.getKey()));
                }
            } else {
                q.add(new ArrayEntry(pair.getValue(), pair.getKey()));
            }
        }
        int[] res = new int[k];
        int i = k - 1;
        while (!q.isEmpty() && i >= 0) {
            res[i] = q.poll().val;
            --i;
        }
        return res;
    }

}

class ArrayEntry {
    int freq;
    int val;

    ArrayEntry(int freq, int val) {
        this.freq = freq;
        this.val = val;
    }
}

class BucketSortApproach {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqArr = new HashMap<>();
        LinkedList<Integer>[] freq = new LinkedList[nums.length + 1];
        int[] res = new int[k];
        for (int n : nums)
            freqArr.put(n, freqArr.getOrDefault(n, 0) + 1);

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new LinkedList<>();
        }
        for (int i : freqArr.keySet()) {
            freq[freqArr.get(i)].addLast(i);// Horror!
        }
        for (int i = freq.length - 1; i >= 0; i--) {
            while (!freq[i].isEmpty() && k > 0) {
                res[k - 1] = freq[i].removeLast();
                k--;
            }
        }
        return res;
    }
}

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
        // We can use bucket sort because max freq of any element could be N
        // We create list of integer array for each bucket

        LinkedList<Integer>[] freqBuckets = new LinkedList[nums.length + 1];
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        // Initialize list for N buckets
        for (int i = 0; i < freqBuckets.length; i++) {
            freqBuckets[i] = new LinkedList<>();
        }
        for (int i : count.keySet()) {
            freqBuckets[count.get(i)].addLast(i);
        }
        int[] ans = new int[k];
        int index = 0;
        for (int i = freqBuckets.length - 1; i >= 0; i--) {
            LinkedList<Integer> elements = freqBuckets[i];
            while (index < k && !elements.isEmpty()) {
                ans[index++] = elements.removeLast();
            }
        }
        return ans;
    }
}

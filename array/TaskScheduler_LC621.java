import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class TaskScheduler_LC621 {
    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        for (int i : freq) {
            if (i > 0)
                maxHeap.add(i);
        }
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // At each iteration we would poll N + 1 distinct elements from the q
            // to keep the CPU busy
            int i = 0;
            while (i++ <= n && maxHeap.size() > 0) {
                temp.add(maxHeap.remove());
            }
            maxHeap.addAll(temp.stream().filter(rec -> rec - 1 > 0).map(rec -> rec - 1).collect(Collectors.toList()));
            time += maxHeap.isEmpty() ? temp.size() : n + 1;
        }
        return time;
    }
    //SDE problem. VV Important problem
    public int leastInterval_optimised(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }
        Arrays.sort(freq);
        int idle = n * (freq[25] - 1);
        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(freq[25] - 1, freq[i]);
        }
        return tasks.length + Math.max(0, idle);
    }
}

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LargestRangeSum_LineSweep_BS887 {
    public int solve(int[] nums, int[][] ranges) {
        // We need to store the frequency of each index and assign numbers from the
        // input array in
        // decreasing order
        Queue<Integer> indexFreq = new PriorityQueue<>(Collections.reverseOrder());

        int res = 0;
        int mod = 1_000_000_007;
        int[] freq = new int[nums.length + 1];
        for (int[] range : ranges) {
            freq[range[0]]++;
            freq[range[1] + 1]--; // This is because j is inclusive
        }
        int idxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            idxFreq += freq[i];
            indexFreq.add(idxFreq);
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            res += (nums[i] * indexFreq.remove());
            res = res % mod;
        }
        return res;
    }
}
/**
 * For array problems with range queries, we somehow need to preprocess the
 * ranges.
 * 
 * In this problem, we use Line-Sweep technique to derive the index of each
 * frequency in O(N) time. This is an absolutely brilliant technique.
 * 
 * We then use a max-heap to store each index frequency and sort the array. Next
 * we sum the numbers * frequency for all the ranges and calculate the answer.
 * 
 */

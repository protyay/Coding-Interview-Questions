import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK_LC560 {
    // SDE problem
    public int subarraySum(int[] nums, int k) {
        // We can use prefixSum
        // 1 2 3 - At each index , we ask whether we have a subarray ending at i,
        // that sums up to K.
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        Map<Integer, Integer> sum = new HashMap<>();
        sum.put(0, 1);
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            // So the max subarray sum ending at index i, is prefixSum[i];
            // If we can remove some prefix from this array, can we achieve our targetsum?
            if (sum.containsKey(prefixSum[i] - k)) {
                count += sum.get(prefixSum[i] - k);
            }
            sum.put(prefixSum[i], sum.getOrDefault(prefixSum[i], 0) + 1);
        }
        return count;
    }

    // Cleaner approach without prefixSum array
    public int subarraySum_withoutPrefixSumArr(int[] nums, int k) {
        int ans = 0, sum = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        for (int num : nums) {
            sum += num;
            ans += prefixSum.getOrDefault(sum - k, 0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}

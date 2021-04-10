import java.util.*;

public class LongestSubListWithKDistinct_BS12 {
    public int solve(int k, int[] nums) {
        if (nums == null)
            return 0;

        if (k == 0)
            return 0;

        if (nums.length <= 1)
            return nums.length;
        // We will have to use HashMap to keep track
        // of the occurence of an element in a given window
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(nums[0], 1);
        int maxSubListLength = 0;

        for (int anchor = 0, explorer = 1; explorer < nums.length; explorer++) {
            frequencyMap.put(nums[explorer], frequencyMap.getOrDefault(nums[explorer], 0) + 1);

            while (frequencyMap.size() > k) {
                // We re-adjust the anchor pointer
                // to maintain ONLY K elements in the map at a given time
                frequencyMap.put(nums[anchor], frequencyMap.get(nums[anchor]) - 1);
                if (frequencyMap.get(nums[anchor]) == 0) {
                    frequencyMap.remove(nums[anchor]);
                }
                ++anchor;
            }
            maxSubListLength = Math.max(maxSubListLength, explorer - anchor + 1);
        }
        return maxSubListLength;
    }

}
/**
 * Another typical Sliding window two pointers question
 * 
 * When we are asked to maintain K Distinct characters, we would use a hashMap
 * to maintain the invariant. 
 * 
 * Check base conditions.
 *
 */
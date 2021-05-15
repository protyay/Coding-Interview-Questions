public class MinSizeSubarraySum_LC209 {
    public int minSubArrayLen(int target, int[] nums) {
        // 2 3 1 2 4 3
        int l = 0, sum = 0, minWindow = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                minWindow = Math.min(minWindow, r - l + 1);
                sum -= nums[l++];
            }
        }
        if (minWindow == Integer.MAX_VALUE)
            return 0;
        return minWindow;
    }
}
/**
 * Always refer to the problem of Minimum Substring Window.
 * That's the parent problem.
 */

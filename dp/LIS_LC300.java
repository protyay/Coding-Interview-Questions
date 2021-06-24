import java.util.Arrays;

public class LIS_LC300 {
    // Brute force beauty
    // SDE problem
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1)
            return 1;
        Integer[][] dp = new Integer[nums.length][nums.length];
        return lis(nums, 0, -1, dp);
    }

    // O(2^N) approach
    private int lis(int[] nums, int currIndex, int prevIndex, Integer[][] dp) {
        if (currIndex == nums.length) {
            return 0;
        }
        if (prevIndex > -1 && dp[prevIndex][currIndex] != null)
            return dp[prevIndex][currIndex];
        int include = 0;
        if (prevIndex < 0 || nums[currIndex] > nums[prevIndex]) {
            include = 1 + lis(nums, currIndex + 1, currIndex, dp);
        }
        int exclude = lis(nums, currIndex + 1, prevIndex, dp);
        if (prevIndex > -1)
            dp[prevIndex][currIndex] = Math.max(include, exclude);
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        LIS_LC300 lc300 = new LIS_LC300();
        int[] nums = { 3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12 };
        int ans = lc300.lengthOfLIS(nums);
        System.out.println("Ans =" + ans);
    }

    // Bottom-up DP
    public int lengthOfLIS_bottomUpDP(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        // dp[i] typically indicates the LIS ending at i
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
/**
 * One of the most important problem. DP[i] stores the LIS starting at i.
 */
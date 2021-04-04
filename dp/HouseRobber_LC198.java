public class HouseRobber_LC198 {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        int N = nums.length - 1;
        return rob(nums, 0, N);
    }

    // This is exponential time complexity
    private int rob(int[] nums, int start, int end) {
        if (start > end)
            return 0;
        int with = nums[start] + rob(nums, start + 2, end);
        int without = rob(nums, start + 1, end);
        return Math.max(with, without);
    }

    // This is Linear time complexity
    public int rob_dp(int[] nums) {
        int N = nums.length;
        if (N == 1)
            return nums[0];

        int[] dp = new int[N];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[N - 1];
    }
}

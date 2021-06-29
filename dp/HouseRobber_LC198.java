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

    public int rob_bottomUpDPArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }

    public int rob_dpConstantSpace(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int jump = nums[0], prev = Math.max(nums[0], nums[1]), max = 0;
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(prev, nums[i] + jump);
            jump = prev;
            prev = max;
        }
        return Math.max(prev, max);
    }
}

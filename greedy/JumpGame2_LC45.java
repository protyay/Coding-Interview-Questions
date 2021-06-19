import java.util.Arrays;

public class JumpGame2_LC45 {
    // SDE problem
    int minJump = Integer.MAX_VALUE;

    public int jump_recursion(int[] nums) {
        // Can i use DP ?
        int N = nums.length;
        // If we have an array length of 1, we have to make zero jumps to reach the end
        if (N <= 1)
            return 0;

        solve(nums, 0, 0);
        return minJump;
    }

    // Build the DP solution
    private void solve(int[] nums, int idx, int count) {
        if (idx >= nums.length - 1) {
            minJump = Math.min(count, minJump);
            return;
        }
        // Try out every jump
        // If a zero is present in any index, we will simply ignore it
        for (int i = 1; i <= nums[idx]; i++) {
            solve(nums, idx + i, count + 1);
        }
    }

    public int jump_bottomUp_DP(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length)
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    public int jump_greedy(int[] nums) {
        // We can record the maximum jump we can make at
        // each index
        // Calc. the total min. amount of jumps required to reach that index

        if (nums.length == 1)
            return 0;

        int maxJump = 0, jumps = 0, currEnd = 0;

        for (int i = 0; i < nums.length; i++) {
            maxJump = Math.max(maxJump, nums[i] + i);

            if (maxJump >= nums.length - 1)
                break;// We know we could always reach the end index

            // Do we need to make a jump in order to move to the next index ?
            if (i == currEnd) {
                ++jumps;
                currEnd = maxJump;
            }
        }
        return jumps + 1;
    }

    public static void main(String[] args) {
        JumpGame2_LC45 lc45 = new JumpGame2_LC45();
        // int[] nums = { 2, 3, 1, 1, 4 };
        int[] nums = { 1, 1, 1, 1 };
        // int[] nums = {2,3,0,1,4};
        // int[] nums = { 4, 4, 4, 4, 4 };
        int ans = lc45.jump_bottomUp_DP(nums);
        System.out.println("Min Jumps = " + ans);
    }
}
/**
 * In the minimisation problem, we again take a similar approach to Jump Game I.
 * In this we check all points till N - 1.
 */
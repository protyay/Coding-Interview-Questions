public class JumpGame2_LC45 {
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

    public int jump_greedy(int[] nums) {
        if (nums.length == 1)
            return 0;
        int currEnd = 0, farthest = 0, jumps = 0;
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);

            if (i == currEnd) {
                currEnd = farthest;
                jumps++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGame2_LC45 lc45 = new JumpGame2_LC45();
        // int[] nums = { 2, 3, 1, 1, 4 };
        // int[] nums = {2,3,0,1,4};
        int[] nums = { 4, 4, 4, 4, 4 };
        int ans = lc45.jump_recursion(nums);
        System.out.println("Min Jumps = " + ans);
    }
}
/**
 * In the minimisation problem, we again take a similar approach to Jump Game I.
 * In this we check all points till N - 1. 
 */
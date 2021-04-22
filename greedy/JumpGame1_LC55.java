public class JumpGame1_LC55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int currEnd = 0, farthest = 0;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (farthest >= N - 1)
                return true;
            if (i == currEnd) {
                // The idea is that if for a window, we couldn't find ANY point that makes
                // the jump beyond the current window end, then we cannot make any progress
                if (farthest == currEnd && farthest < N - 1)
                    return false;

                currEnd = farthest;
            }
        }
        return true;
    }
}
/**
 * We take a greedy approach where in we consider a window at every step.
 * The end of window = maximum jump among all points in the window
 * If at any point we reach the end, return true;
 * 
 * If we reach the end of the current window and check that the farthest is STILL the 
 * end of the current window, then we are sure we cannot progress any further.
 * 
 */

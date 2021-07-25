public class JumpGame1_LC55 {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;
        int maxReach = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxReach < i)
                return false;
            maxReach = Math.max(maxReach, nums[i] + i);
        }
        return true;
    }
}
/*
 * At each index , we check if it's possible to reach that index. We keep
 * checking until we reach the end of the array.
 */

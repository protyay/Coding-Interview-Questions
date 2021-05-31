public class FindDuplicateinArray_LC287 {
    // SDE Repeat
    // [1, 3, 4, 2, 2] (0, 1 ,2, 3, 4);
    public int findDuplicate(int[] nums) {
        // This is also a nice trick.
        // It helps to understand that because we are in a loop, we'll encounter some
        // element
        // whose value has already been visited.
        for (int i = 0; i < nums.length; ++i) {
            int val = Math.abs(nums[i]);
            if (nums[val] < 0)
                return val;
            nums[val] *= -1;
        }
        return 0;
    }

    public int findDuplicate_SlowAndFast(int[] nums) {
        int slow = nums[0], fast = nums[0];

        // slow = 1, fast = 1
        // s = 3, f = 2
        // s=2, f=2
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // Intuitive explanation of why slow is guaranted to meet fast
        // We will slow == fast when slow enters the cycle.
        // We take fast out of loop and place it in the front. Slow will
        // keep cycling through the cycle and they will meet.

        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}

/**
 * [1, 3, 4, 2, 2] (0, 1 ,2, 3, 4); // Start with zero, treat element at the
 * index as the index to be visited next // 0(1) -> 1(3)->3(2) -> 2(4) -> 4(2)
 * -> 2(4) -> So on and so forth LL cycle =
 */
class DuplicateCheck {
    public int findDuplicate(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            res ^= i;
        }
        return res;
    }
    // We could easily check for a duplicate num if we KNOW FOR SURE 
    // that we it's repeating ONLY for a fixed num
}
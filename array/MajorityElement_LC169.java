public class MajorityElement_LC169 {
    // SDE problem
    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int majority = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                majority = nums[i];

            if (nums[i] == majority)
                count++;
            else
                count--;
        }
        return majority;
    }
}
/**
 * Moore's Voting algorithm
 */

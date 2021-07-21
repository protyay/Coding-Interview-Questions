public class FirstMissingPositive_LC41 {
    // SDE
    public int firstMissingPositive(int[] nums) {
        int N = nums.length; // This is the maximum that could be missing

        // We remove un-necessary numbers from the input array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > N)
                nums[i] = 0;
        }
        // 3 4 -1 1 --> 3 0 0 1
        // 3
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (val == 0 || val == N + 1)
                continue;
                // We use the input array as hash-set
            if (nums[val - 1] > 0)
                nums[val - 1] *= -1;
            else if (nums[val - 1] == 0)
                nums[val - 1] = -(N + 1);
        }

        for (int i = 1; i <= N; i++) {
            if (nums[i - 1] >= 0)
                return i;
        }
        return N + 1;
    }
}
/**
 * Weird but very important proble given how we manipulate the index
 */
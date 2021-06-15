public class FirstMissingPositive_LC41 {
    // SDE
    public int firstMissingPositive(int[] nums) {
        int N = nums.length; // This is the maximum that could be missing

        // We modify the input array to make this a constant time solution
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > N)
                nums[i] = 0;
        }
        // 1 -9 12 0 3 2 -11 ----> 1 0 0 0 3 2 0
        // -1
        for (int i = 0; i < nums.length; i++) {
            // We'll mark the presence of each number by calc. it's index (nums - 1)
            int val = Math.abs(nums[i]);
            if (val == 0 || val == N + 1)
                continue;
            // We do not need to record the presence of a zero
            // Also, recall in the previous for loop we have overridden all values > N to 0.
            // So we should not concern ourselves with value = N + 1 either

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
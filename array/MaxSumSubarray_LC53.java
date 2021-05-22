public class MaxSumSubarray_LC53 {
    // Brute force - TC - O(N^2) Space Complecity - O(1)
    public int maxSubArray_On2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            maxSum = Math.max(maxSum, sum);
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[j] + sum;
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // DP SC - O(1), TC - O(N);
    public int maxSubArray_DP(int[] nums) {
        int sum = nums[0] < 0 ? 0 : nums[0];
        int max = nums[0]; // We can have all negative numbers in the array
        for (int i = 1; i < nums.length; i++) {
            sum = sum + nums[i];
            max = Math.max(sum, max);
            if (sum < 0)
                sum = 0;
        }
        return max;
    }
    // Same approach with better explanation
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int n : nums) {
            // Remember the max at any index can be derive from
            // 1. Sum of all prev.elements + curr element
            // 2. Max element till prev index remains the max index here.
            maxSum = Math.max(maxSum, sum + n);
            // Restore the sum to zero everytime it goes negative.
            // Because we are including sum in our max comparison
            sum = Math.max(0, sum + n);
        }
        return maxSum;
    }

}

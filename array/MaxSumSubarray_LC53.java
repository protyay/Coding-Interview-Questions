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

}

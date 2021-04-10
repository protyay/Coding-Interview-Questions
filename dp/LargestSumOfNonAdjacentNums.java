import java.util.Arrays;

public class LargestSumOfNonAdjacentNums {
    public int solve(int[] nums) {
        if (nums.length == 1)
            return Math.max(0, nums[0]);

        int sum = Arrays.stream(nums).boxed().filter(i -> i > 0).mapToInt(i -> i).sum();

        if (sum == 0)
            return 0;
        
        return maxSum(nums, 0, 0);
    }

    private int maxSum(int[] nums, int index, int currSum) {
        if (index >= nums.length) {
            return currSum;
        } else {
            int select = 0, reject = 0;
            // if the number is positive we have two options, we either select OR reject
            if (nums[index] > 0) {
                // we select the current element and skip the next
                select = maxSum(nums, index + 2, currSum + nums[index]);
            }
            // we skip the current element and move on to the next element.
            reject = maxSum(nums, index + 1, currSum);

            return Math.max(select, reject);

        }
    }

    public static void main(String[] args) {
        LargestSumOfNonAdjacentNums lNums = new LargestSumOfNonAdjacentNums();
        int[] arr = { 1, 2, 0, 0 };
        int maxSum = lNums.solve(arr);
        System.out.println("max sum =" + maxSum);
    }
}

class BottomUpNonAdjacent {
    public int solve(int[] nums) {
        if (nums.length == 1)
            return Math.max(0, nums[0]);

        int sum = Arrays.stream(nums).boxed().filter(i -> i > 0).mapToInt(i -> i).sum();
        // System.out.println(sum);
        if (sum == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = Math.max(0, nums[0]);
        // DP Initialization
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n];
    }
}

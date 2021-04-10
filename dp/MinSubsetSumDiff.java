import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1#
 */
public class MinSubsetSumDiff {
    private int diff = Integer.MAX_VALUE;

    public int minDiffernce(int arr[], int n) {
        // Your code goes here
        int sum = Arrays.stream(arr).boxed().mapToInt(i -> i).sum();
        Integer[][] dp = new Integer[n][sum + 1];
        return minDiff(arr, sum, 0, 0, dp);
    }

    private int minDiff(int[] arr, int sumA, int sumB, int index, Integer[][] dp) {
        // Base-case
        if (index == arr.length) {
            diff = Math.min(diff, Math.abs(sumA - sumB));
            return diff;
        } else if (index > arr.length)
            return Integer.MAX_VALUE;
        else if (dp[index][sumA] != null)
            return dp[index][sumA];
        else {
            // We have two choice
            // Include the index ele at subset A or subset B
            int toSetB = minDiff(arr, sumA - arr[index], sumB + arr[index], index + 1, dp);
            int toSetA = minDiff(arr, sumA, sumB, index + 1, dp);
            dp[index][sumA] = Math.min(toSetB, toSetA);
            return dp[index][sumA];
        }
    }
}
/**
 * Minimum Subset Sum Difference - Typical 0/1 Knapsack Problem. 
 * 
 * The base cases requires special attention, both at what point to terminate and what to return. 
 * Ideally, in this choice problem, the base case triggers when we have seen all the elements in the array.
 * This HOLDS good for quite a few DP problem.
 * 
 * For Memoization, please notice what are the dependent state variables.
 * If the range of the dependent state variables are pretty HIGH, then iterative -tabulation approach is the way to go.
 * 
 * Use Integer.MIN_VALUE or Integer.MAX_VALUE as indicators of invalid branching conditions in recursion.
 * 
 * Make sure to understand the choices at each index and how to optimally express that. That's problem half done
 */

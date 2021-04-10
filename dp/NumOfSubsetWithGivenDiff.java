import java.util.Arrays;

public class NumOfSubsetWithGivenDiff {
    int ways = 0;

    public int countSubset(int[] nums, int S) {
        // Subset partition with diff = S
        int totalSum = Arrays.stream(nums).boxed().mapToInt(i -> i).sum();
        int targetSum = (S + totalSum) / 2;
        // How many ways can we select elements from the array that sums upto targetSum;
        int[][] dp = new int[nums.length + 1][targetSum + 1];

        // If we have any number of elements, we have one way of reaching sum = 0;
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        // Recurrence
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= targetSum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][targetSum];
    }

    public static void main(String[] args) {
        NumOfSubsetWithGivenDiff diff = new NumOfSubsetWithGivenDiff();
        int[] nums = { 1, 1, 2, 3 };
        int S = 1;
        int ans = diff.countSubset(nums, S);
        System.out.println("Ans = " + ans);
    }
}

import java.util.Arrays;

public class TargetSum_LC494 {
    private int ways = 0;

    public int findTargetSumWays(int[] nums, int S) {
        int totalSum = Arrays.stream(nums).boxed().mapToInt(i -> i).sum();
        findWays(nums, S, totalSum, 0);
        return ways;
    }

    private void findWays(int[] nums, int S, int start, int index) {
        if (start == S) {
            ++ways;
            return;
        }
        if (index >= nums.length || start < S)
            return; // No further branch to explore

        // We add negative to the current element.
        findWays(nums, S, start - nums[index] - nums[index], index + 1);
        // We don't add negative to the current element.
        findWays(nums, S, start, index + 1);
    }

    public static void main(String[] args) {
        TargetSum_LC494 lc494 = new TargetSum_LC494();
        int[] nums = { 1, 1, 1, 1, 1 };
        int sum = 3;
        int ans = lc494.findTargetSumWays(nums, sum);
        System.out.println("Ways =" + ans);
    }
}

class TargetSum_LC494_DP {
    public int findTargetSumWays(int[] nums, int S) {
        int totalSum = Arrays.stream(nums).boxed().mapToInt(i -> i).sum();
        if (totalSum < S || (S + totalSum) % 2 > 0)
            return 0;
        int targetSum = (S + totalSum) / 2;
        // How many ways can we select elements from the array that sums upto targetSum;
        int[][] dp = new int[nums.length + 1][targetSum + 1];

        // If we have any number of elements, we have one way of reaching sum = 0;
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        // Solution states
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= targetSum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println("-------------------------------------------");
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.print("-------------------------------------------");
        return dp[nums.length][targetSum];
    }

    public static void main(String[] args) {
        TargetSum_LC494_DP lc494 = new TargetSum_LC494_DP();
        int[] nums = { 1, 1, 1, 1, 1,1,1,1,0 };
        int sum = 1;
        int ans = lc494.findTargetSumWays(nums, sum);
        System.out.println("Ways =" + ans);
    }
}

import java.util.Arrays;

public class EqualSumSubsetPartition_LC416 {
    // Simple Top-down approach without Memoization
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        if (nums.length == 1)
            return nums[0] == 0;
        int totalSum = Arrays.stream(nums).boxed().mapToInt(i -> i).sum();
        return checkSum(nums, totalSum, 0, 0);
    }

    private boolean checkSum(int[] nums, int sumA, int sumB, int index) {
        if (sumB > sumA || index == nums.length)
            return false; // Equality not achieved. Stop exploring the current branch
        if (sumB == sumA)
            return true;

        if (checkSum(nums, sumA - nums[index], sumB + nums[index], index + 1) || checkSum(nums, sumA, sumB, index + 1))
            return true;

        return false;
    }
}

class DPBottomUpSolution {
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).boxed().mapToInt(i -> i).sum();
        if (totalSum % 2 == 1)
            return false;
        int targetSum = totalSum / 2;
        boolean[][] dp = new boolean[nums.length + 1][targetSum + 1];

        // Initialization
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        // State transition is if we can pick the current element, then we choose if
        // picking up
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= targetSum; j++) {
                // For this target sum, we have two options. Either we select the i'th element
                // in the array OR not. We check if we can build the current target sum with
                // either of the approaches.
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][targetSum];
    }
}

class LC416TopDownMemoization {
    
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        if (nums.length == 1)
            return nums[0] == 0;
        int totalSum = Arrays.stream(nums).boxed().mapToInt(i -> i).sum();
        Boolean[][] dp = new Boolean[nums.length + 1][totalSum + 1];
        return checkSum(nums, totalSum, 0, 0, dp);
    }

    private boolean checkSum(int[] nums, int sumA, int sumB, int index, Boolean[][] dp) {
        if (index == nums.length && sumA == sumB)
            return true;
        else if (sumB > sumA || index >= nums.length)
            return false;
        else if (dp[index][sumA] != null)
            return dp[index][sumA];
        else {
            boolean res = checkSum(nums, sumA - nums[index], sumB + nums[index], index + 1, dp)
                    || checkSum(nums, sumA, sumB, index + 1, dp);
            dp[index][sumA] = res;

            return dp[index][sumA];
        }
    }
}
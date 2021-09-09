import java.util.Arrays;

public class ThreeSumClosest_LC16 {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, closestSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    closestSum = sum;
                }
                if (sum < target)
                    start++;
                else if (sum > target)
                    end--;
                else
                    return target;
            }
        }
        return closestSum;
    }
}

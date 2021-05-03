import java.util.Arrays;

public class FirstMissingPositive_LC41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length - 1;
        if (nums.length == 1)
            return nums[0] == 1 ? 2 : 1;
        int oneIndex = Arrays.binarySearch(nums, 1);
        if (oneIndex < 0)
            return 1;
        else {
            // Because we need the first positive, we start searching the arr from the 1
            // index
            for (int i = oneIndex; i < nums.length - 1; i++) {
                if (nums[i + 1] - nums[i] > 1)
                    return nums[i] + 1;
            }
            return nums[N] + 1;
        }
    }
}

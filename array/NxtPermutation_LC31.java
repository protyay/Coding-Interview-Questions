public class NxtPermutation_LC31 {
    // SDE
    // Repeat
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;

        // Find the decreasing point
        int right = nums.length - 2; // 2 3
        while (right >= 0 && nums[right] >= nums[right + 1]) {
            right--;
        }
        if (right >= 0) {
            

            int k = nums.length - 1;
            while (nums[k] <= nums[right])
                k--;

            swap(nums, k, right);
        }
        reverse(nums, right + 1, nums.length - 1);
    }

    private void swap(int[] nums, int posA, int posB) {
        int temp = nums[posA];
        nums[posA] = nums[posB];
        nums[posB] = temp;
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            swap(nums, from, to);
            from++;
            to--;
        }
    }
}
/**
 * To come up with the next greater permutation we need to find the decreasing
 * element from the right. This means that
 */

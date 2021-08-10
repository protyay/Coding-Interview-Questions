public class NxtPermutation_LC31 {
    // SDE
    // Repeat
    public void nextPermutation(int[] nums) {
        int l = nums.length - 2;
        while (l >= 0 && nums[l] >= nums[l + 1]) {
            l--;
        }
        int pivot = l;
        int nextGreater = -1;
        if (l >= 0) {
            nextGreater = findNextGreaterNum(nums, pivot);
            swap(nums, nextGreater, pivot);
        }
        reverse(nums, pivot + 1);
    }

    private int findNextGreaterNum(int[] nums, int fromIndex) {
        int baseValue = nums[fromIndex];
        int start = nums.length - 1;
        while (nums[start] <= baseValue)
            start--;
        return start;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    private void reverse(int[] nums, int from) {
        int to = nums.length - 1;
        while (from < to) {
            swap(nums, from++, to--);
        }
    }
}
/**
 * To come up with the next greater permutation we need to find the decreasing
 * element from the right. This means that
 */

public class NxtPermutation_LC31 {
    public void nextPermutation(int[] nums) {
        // 1 4 8 5
        if (nums == null || nums.length == 1)
            return;

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            // there's atleast one valid index
            int k = nums.length - 1;
            while (nums[k] <= nums[i] && k > i) {
                k--;
            }
            swap(nums, i, k);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            ++start;
            --end;
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
/**
 * For typical array transformation problems,
 * try and find out a pattern that's repeating. 
 * 
 * Especially a breaking point.
 * 
 * Then try to look for an invariant.
 * 
 * Code the problem
 */

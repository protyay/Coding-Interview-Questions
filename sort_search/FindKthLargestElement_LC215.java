public class FindKthLargestElement_LC215 {
    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        return findKSmallest(nums, lo, hi, nums.length - k);
    }

    private int findKSmallest(int[] nums, int lo, int hi, int k) {
        int pivotIndex = this.partition(nums, lo, hi, nums[hi]);
        if (k < pivotIndex)
            return findKSmallest(nums, lo, pivotIndex - 1, k);
        else if (k > pivotIndex)
            return findKSmallest(nums, pivotIndex + 1, hi, k);
        else
            return nums[pivotIndex];
    }

    public int partition(int[] nums, int lo, int hi, int pivotElement) {
        int start = lo, replaceIndex = lo;
        while (start < hi) {
            if (nums[start] > pivotElement)
                ++start;
            else {
                swap(nums, start++, replaceIndex++);
            }
        }
        swap(nums, hi, replaceIndex);
        return replaceIndex;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {8,6,1,7,4,9};
        FindKthLargestElement_LC215 lc215 = new FindKthLargestElement_LC215();
        int ans = lc215.findKthLargest(nums, 2);
        System.out.println("k-th largest ="+ans);
    }
}
/**
 * Sample example 
 * [8,6,1,7,4,9]
 * pivot = 9
 * [9,6,1,7,4,8]
 */

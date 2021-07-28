public class QuickSelect {

    public int findKSmallest(int[] nums, int k) {
        if (k > nums.length)
            return -1; // Invalid scenario
        
        return findKSmallest(nums, lo, hi, k-1);
    }

    private int findKSmallest(int[] nums, int lo, int hi, int k) {
        QuickSort sort = new QuickSort();
        int pivotIndex = sort.partition(nums, lo, hi, nums[hi]);
        if (k < pivotIndex)
            return findKSmallest(nums, lo, pivotIndex - 1, k);
        else if (k > pivotIndex)
            return findKSmallest(nums, pivotIndex + 1, hi, k);
        else
            return nums[pivotIndex];
    }

    public static void main(String[] args) {
        QuickSelect select = new QuickSelect();
        int[] nums = { 8, 5, 1, 3, 7, 2, 9, 6 };
        int k = 4;
        int ans = select.findKSmallest(nums, k);
        System.out.println("Kth Smallest =" + ans);
    }

}

public class SearchInARotatedSortedArr_LC33 {
    // Each element is DISTINCT
    public int search(int[] nums, int target) {
        // The array is sorted in ascending order
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[lo] <= nums[mid])// Lo-Mid is sorted
            {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else
                    lo = mid + 1;
            } else if (nums[mid] <= nums[hi]) { // Mid-HI is sorted
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else
                    hi = mid - 1;
            }
        }
        return -1;
    }
}

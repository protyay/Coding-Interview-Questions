public class FindPeakElement_LC162 {
    // SDE problem
    public int findPeakElement_linearTime(int[] nums) {
        // Find the breaking point.
        if (nums.length == 1)
            return 0;
        // 5 4 3 2 1 - 0
        // 1 2 3 - 2
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > prev && nums[i] > nums[i + 1]) {
                // We found the peak
                return i;
            }
        }
        return nums.length - 1;
    }

    public int findPeakElement_nlogN_binSearch(int[] nums) {
        if (nums.length == 1)
            return 0;

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // Two cases, Mid = 0 or mid is Last element
            if (mid == 0) {
                if (nums[mid] > Integer.MIN_VALUE && nums[mid] > nums[1])
                    return mid;
                lo = mid + 1;
            } else if (mid == nums.length - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > Integer.MIN_VALUE)
                    return mid;
                hi = mid - 1;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else {
                // Peak lies in the left half
                if (nums[mid] < nums[mid - 1]) {
                    hi = mid - 1;
                } else {
                    // peak lies in the right half
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }
}

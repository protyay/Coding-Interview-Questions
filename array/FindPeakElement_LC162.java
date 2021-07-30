public class FindPeakElement_LC162 {
    // SDE problem
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        int N = nums.length;
        int lo = 0, hi = nums.length;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int left = mid - 1 < 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int right = mid + 1 >= N ? Integer.MIN_VALUE : nums[mid + 1];
            ans = mid;
            if (nums[mid] > left && nums[mid] > right)
                return mid;
            else if (right > left)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return ans;
    }
}

public class MajorityEleInASortedArr_LC1150 {
    // SDE problem
    public boolean isMajorityElement(int[] nums, int target) {
        // Find the first occurence of an ele in a sorted arr
        int firstIdx = findFirst(nums, target);
        int endIdx = firstIdx + (nums.length / 2);
        if (endIdx < nums.length && nums[endIdx] == target)
            return true;
        return false;
    }

    private int findFirst(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }
}

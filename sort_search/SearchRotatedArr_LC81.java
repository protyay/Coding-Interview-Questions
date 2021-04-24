public class SearchRotatedArr_LC81 {
    // Each element is DISTINCT
    public int search(int[] nums, int target) {
        // We have two halves of the array that are sorted
        // When we apply BinSearch on the full array, the mid element might be in one of
        // these halves.
        // The next key idea is to determine the half where the target element is - In
        // the left or right of
        // the pivot. If the target is NOT on one half, we discard one sorted half and
        // resume our binary search
        // on the other half.
        // TC - [1], [3,1],[4 5 6 7 0 1 2], [1 2 3 4 5 6]
        // [2,5,6,0,0,1,2] - Start index must be adjusted if nums[start] == nums[end]
        // [1 0 1 1 1]

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;

            // Let's assume the array is pivoted and the mid element lies on the first
            // rotated half
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]) {
                if (target >= nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }

        }
        return -1;

    }
}

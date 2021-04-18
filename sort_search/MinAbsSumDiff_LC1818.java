import java.util.Arrays;

public class MinAbsSumDiff_LC1818 {
    /**
     * [1,10,4,4,2,7] => [1,2,4,4,7,10]
     * 
     * [9,3,5,1,7,4]
     * 
     * Diff Sum = 8 + 7 + 1 + 3 + 5 + 3 = 27
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] nums1Sorted = nums1.clone();
        int N = nums1.length, idx = 0;
        long diffSum = 0;
        int mod = 1_000_000_007;
        while (idx < N) {
            diffSum += Math.abs(nums1[idx] - nums2[idx]);
            ++idx;
        }
        Arrays.sort(nums1Sorted);
        // For each element in nums2, find the closest element in nums1Sorted
        long minDiff = diffSum;
        idx = 0;
        for (int num : nums2) {
            // 27 - (8,1)
            long betterSum = diffSum - Math.abs(nums1[idx] - nums2[idx])
                    + Math.abs(nums2[idx] - closestElement(num, nums1Sorted));
            minDiff = Math.min(minDiff, betterSum);
            ++idx;
        }
        return (int) (minDiff % mod);
    }

    private int closestElement(int target, int[] arr) {
        int idx = Arrays.binarySearch(arr, target);
        // If the target element already exists, then the sum can be minimized by TARGET
        if (idx >= 0)
            return target;
        idx = -1 - idx;
        int dist = Integer.MAX_VALUE;
        int maxEle = 0;

        if (idx > 0) {
            if (dist > target - arr[idx - 1]) {
                dist = target - arr[idx - 1];
                maxEle = arr[idx - 1];
            }
        }
        if (idx < arr.length) {
            if (dist > arr[idx] - target) {
                dist = arr[idx] - target;
                maxEle = arr[idx];
            }
        }
        return maxEle;
    }

    public static void main(String[] args) {
        MinAbsSumDiff_LC1818 lc1818 = new MinAbsSumDiff_LC1818();
        // int[] nums1 = { 1, 10, 4, 4, 2, 7 }, nums2 = { 9, 3, 5, 1, 7, 4 };
        int[] nums1 = { 2121212121, 41212121, 62121219, 89999981, 1000000007 }, nums2 = { 2, 4, 6, 8, 10 };
        int ans = lc1818.minAbsoluteSumDiff(nums1, nums2);
        System.out.println("Minimum possible diff =" + ans);
    }
}

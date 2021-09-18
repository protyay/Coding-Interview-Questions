public class MedianOfTwoSortArr_LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        int small[] = nums1.length < nums2.length ? nums1 : nums2;
        int larger[] = small == nums1 ? nums2 : nums1;

        int n1 = small.length, n2 = larger.length;
        int lo = 0, hi = n1;

        while (lo <= hi) {
            int cutA = lo + (hi - lo) / 2;
            int cutB = half - cutA;

            // Define the boundary elements, l1, l2 r1, r2
            int l1 = cutA == 0 ? Integer.MIN_VALUE : small[cutA - 1];
            int l2 = cutB == 0 ? Integer.MIN_VALUE : larger[cutB - 1];

            int r1 = cutA == n1 ? Integer.MAX_VALUE : small[cutA];
            int r2 = cutB == n2 ? Integer.MAX_VALUE : larger[cutB];

            if (l1 <= r2 && l2 <= r1) {
                if (total % 2 == 1)
                    return Math.max(l1, l2) * 1.0;
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2)
                hi = cutA - 1;
            else
                lo = cutA + 1;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 4, 7, 8, 12 };
        int[] nums2 = { 2, 6, 7 };
        MedianOfTwoSortArr_LC4 lc4 = new MedianOfTwoSortArr_LC4();
        double ans = lc4.findMedianSortedArrays(nums1, nums2);
        System.out.println("Ans = " + ans);
    }
}

class SecondApproach {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int N1 = nums1.length, N2 = nums2.length;
        int leftReqd = (N1 + N2 + 1) / 2;
        boolean isEven = (N1 + N2) % 2 == 0;
        int lo = 0, hi = N1;

        while (lo <= hi) {
            int mid1 = lo + (hi - lo) / 2;

            int mid2 = leftReqd - mid1;

            int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];

            int r1 = mid1 == N1 ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = mid2 == N2 ? Integer.MAX_VALUE : nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                double ans = (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                if (!isEven) {
                    ans = Math.max(l1, l2) * 1.0;
                }
                return ans;
            } else if (l1 > r2)
                hi = mid1 - 1;
            else
                lo = mid1 + 1;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        // int[] nums1 = { 1, 4, 7, 8, 12 };
        int[] nums1 = { 1, 8, 9, 10 };
        // int[] nums2 = { 2, 6, 7 };
        int[] nums2 = { 3, 12, 15 };
        SecondApproach lc4 = new SecondApproach();
        double ans = lc4.findMedianSortedArrays(nums1, nums2);
        System.out.println("Ans = " + ans);
    }
}
/**
 * There are very important three points to conside in this problem 1. To
 * consitently handle empty subarrays - we need to introduce a construct of
 * infinity values 2. make sure you use equals in l1 and r2 and l2 and r1
 * comparison
 */

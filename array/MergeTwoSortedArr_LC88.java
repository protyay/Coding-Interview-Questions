public class MergeTwoSortedArr_LC88 {
    // SDE Repeat
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pA = m - 1;
        int pB = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (pB < 0)
                break;

            if (pA >= 0 && nums1[pA] > nums2[pB]) {
                nums1[i] = nums1[pA--];
            } else {
                nums1[i] = nums2[pB--];
            }
        }
    }
}
/**
 * Very important question. Take care of edge cases.
 */

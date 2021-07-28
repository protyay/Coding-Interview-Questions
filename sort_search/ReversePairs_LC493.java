import java.util.Arrays;

public class ReversePairs_LC493 {
    int count = 0;

    public int reversePairs(int[] nums) {

        int lo = 0, hi = nums.length - 1;
        mergeSort(nums, lo, hi);
        return count;
    }

    // Divide
    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo == hi)
            return;

        int mid = lo + (hi - lo) / 2;

        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);

        merge(nums, lo, mid, hi);
    }

    // Conquer
    private void merge(int[] nums, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;
        while (i <= mid && j <= hi) {
            long numsi = (long) nums[i];
            long numsj = (long) nums[j];
            if (numsi > 2 * numsj) {
                count += mid + 1 - i;
                j++;
            } else
                i++;
        }
        Arrays.sort(nums, lo, hi + 1);
    }
}

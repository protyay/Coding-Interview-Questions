import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = { 2, 8, 1, 4, 3, 9, 7,9};

        mergeSort(nums);
        System.out.println("Merged array =" + Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums) {
        if (nums.length < 2)
            return;
        int mid = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, mid);
        mergeSort(left);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        mergeSort(right);

        // Merge the two arrays
        merge(nums, left, right);
    }

    private static void merge(int[] nums, int[] left, int[] right) {
        int pL = 0, pR = 0, index = 0;
        while (pL < left.length && pR < right.length) {
            if (left[pL] < right[pR]) {
                nums[index++] = left[pL++];
            } else {
                nums[index++] = right[pR++];
            }
        }
        while (pL < left.length) {
            nums[index++] = left[pL++];
        }
        while (pR < right.length) {
            nums[index++] = right[pR++];
        }
    }
}
/**
 * Space complexity - O(N)
 * Time complexity - O(N LOGN) - We have N levels each, and at each level we are dividing the array in half
 * If we need K divisions, then N/2^K = 1, we keep dividing the array until we have a single element in the array
 */

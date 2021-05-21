import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        // Sorting in asc order
        int[] nums = { 2, 8, 1, 4, 3, 9, 7 };
        int n = nums.length;
        int i = 0;
        while (i++ < n) {
            int flag = 0;
            for (int j = 0; j < n - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    flag = 1;
                }
            }
            if (flag == 0)
                break;
        }
        System.out.println(Arrays.toString(nums));
    }
}
/**
 * Bubble sort can be optimised for nearly sorted arrays
 * with the introduction of flag variable.
 * best case = O(N), Worst case = O(N^2)
 */

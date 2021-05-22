import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = { 2, 8, 1, 4, 3, 9, 7 };
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
/**
 * Runtime of the algorithm is O(N^2)
 * We select the minimum in the RANGE [i+1..N-1] at every step and place at i
 * Stable sorting algorithm
 */

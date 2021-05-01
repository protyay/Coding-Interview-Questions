import java.util.Arrays;
/**
 * SDE(Binary Search) problem
 */
public class TriangeTriplets_BS242 {
    public int solve(int[] nums) {
        // Two sum greater than target
        // nums[i] + nums[j] - nums[k] > 0
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int sum = nums[i] + nums[j];
                int lo = j + 1, hi = nums.length - 1;
                int end = j;
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (nums[mid] < sum) {
                        end = Math.max(end, mid);
                        lo = mid + 1;
                    } else
                        hi = mid - 1;
                }
                count += (end - j);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TriangeTriplets_BS242 bs242 = new TriangeTriplets_BS242();
        int[] nums = { 7, 8, 8, 9, 15, 15, 15, 100, 100 };
        bs242.solve(nums);
    }
}
/**
 * In binary search, if there's a definite rule if we have multiple occurence of
 * a number, then the library function is undefined for it.
 * So, if we implement the custom binary search option, we would need to make sure 
 * that we introduce a variable to track the index
 * 
 * This problem can also be implemented using a two pointer approach. Very similar to three sum problem
 * where the invariant is num
 */

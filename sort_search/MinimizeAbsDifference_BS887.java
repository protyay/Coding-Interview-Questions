import java.util.Arrays;
/**
 * This is a typical Binary search problem. We can use Binary search to find
 * the closest element of a given element in an array
 */
public class MinimizeAbsDifference_BS887 {
    public int solve(int[] a, int[] b, int[] c) {
        Arrays.sort(a);
        Arrays.sort(c);
        int ans = Integer.MAX_VALUE;
        for (int ele : b) {
            ans = Math.min(ans, calcDiff(a, ele) + calcDiff(c, ele));
        }
        return ans;
    }
    private int calcDiff(int[] arr, int val) {
        int ans = Integer.MAX_VALUE;
        int idx = Arrays.binarySearch(arr, val);
        if (idx >= 0)
            return 0; // If we've found the element, it's diff is zero;
        else {
            idx = -1 - idx;

            // Find smallest larger number of val
            if (idx < arr.length) {
                ans = Math.min(ans, arr[idx] - val);
            }
            if (idx > 0) {
                ans = Math.min(ans, val - arr[idx - 1]);
            }
        }
        return ans;
    }
}

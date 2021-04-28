public class TrappingRainWater_LC42 {
    public int trap(int[] height) {
        // Solve this with the most optimal solution
        int lMax = 0, l = 0, rMax = 0, r = height.length - 1;
        int res = 0;
        while (l <= r) {
            if (height[l] <= height[r]) {
                if (height[l] > lMax)
                    lMax = height[l];
                else
                    res += lMax - height[l];
                l++;
            } else {
                if (height[r] > rMax)
                    rMax = height[r];
                else
                    res += rMax - height[r];
                r--;
            }
        }
        return res;
    }
}
/**
 * Striver's video
 * We can also do this using suffix array and prefix array
 * And the constant space solution is extended from that very idea,
 * for each index, we do calculate the water trapped based on the lMax
 * IF AND ONLY IF height[L] <= height[R].
 * So, we know that this height is LESS THAN EQUALS to R.
 * Now, we check if the current height is better than the LEFT MAX(initially 0).
 * Then, we update the left MAX and water trapped will be zero here because
 * leftMax - leftMax = 0;
 * 
 */

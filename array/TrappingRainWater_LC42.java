public class TrappingRainWater_LC42 {
    // SDE problem
    public int trap(int[] height) {
        // Solve this with the most optimal solution
        int lMax = 0, l = 0, rMax = 0, r = height.length - 1;
        int res = 0;
        while (l <= r) {
            if (height[l] <= height[r]) {
                if (height[l] > lMax)
                    lMax = height[l]; // we trap water because we know height[l] is less than lMax and 
                    // height[l] is ALSO less than height[r]. So we atleast buildings on both sides which 
                    // are atleast as long as height[l];
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
 * The most important invariant of the problem is
 * to understand that water is trapped only when the current height
 * is less than BOTH of the lmax as well as rmax
 * 
 * 
 */

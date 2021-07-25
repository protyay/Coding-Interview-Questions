public class TrappingRainWater_LC42 {
    // SDE problem
    public int trap(int[] height) {
        if (height.length < 3)
            return 0;
        int l = 0, r = height.length - 1;
        int maxLeft = height[l], maxRight = height[r];
        int sum = 0;

        while (l <= r) {
            if (height[l] <= height[r]) {
                if (maxLeft > height[l])
                    sum += maxLeft - height[l];
                maxLeft = Math.max(maxLeft, height[l]);
                l++;
            } else if (height[r] < height[l]) {
                if (maxRight > height[r])
                    sum += maxRight - height[r];
                maxRight = Math.max(maxRight, height[r]);
                r--;
            }
        }
        return sum;
    }
}
/**
 * Striver's video
 * 
 * 
 * When in an interview try to present the brute-force Both with suffix and
 * prefix array
 * 
 * Try to answer the following questions to explain the intuition of the optimal
 * solution
 * 
 * When we are at a current index, we need to determine if we CAN trap any water
 * ?
 * 
 * This is ONLY determined by the fact that if we have a higher elevation on
 * both sides of the current inde.
 * 
 * Once we are sure, we have higher elevation on both side, we ALSO need to
 * determine the minimum of that elevation.
 * 
 * Now for two pointer approach, we ONLY move the left pointer if it's less than
 * or equal to the right pointer and set that as the left max.
 * 
 * We do the same for the right-max.
 * 
 * So we are pretty sure that whenever we select the leftMax and rightMax, we
 * are actually selecting the minimum of both of these values.
 * 
 * That's the invariant of the problem.
 * 
 * 
 * 
 */

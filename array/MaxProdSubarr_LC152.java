public class MaxProdSubarr_LC152 {
    // SDE
    public int maxProduct(int[] nums) {
        int currMax = 1, currMin = 1;
        if (nums.length == 1)
            return nums[0];

        int res = 0;
        for (int n : nums) {
            if (n == 0) {
                currMax = 1;
                currMin = 1;
                continue;
            }
            int temp = currMax * n;
            currMax = Math.max(temp, Math.max(n * currMin, n));
            currMin = Math.min(temp, Math.min(n * currMin, n));
            res = Math.max(res, Math.max(currMax, currMin));
        }
        return res;
    }
}

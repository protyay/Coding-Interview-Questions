public class IncreasingTriplet_LC334 {
    // This is a valid LIS implementation. 
    // But it is NOT necessary
    public boolean increasingTriplet_LIS(int[] nums) {
        int[] dp = new int[nums.length];

        if (nums == null || nums.length < 3)
            return false;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = dp[j] + 1;
                if (dp[i] == 3)
                    return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n < a)
                a = n;
            else if (n < b && n > a)
                b = n;
            else if (n > a && n > b)
                return true;
        }
        return false;
    }
    
}

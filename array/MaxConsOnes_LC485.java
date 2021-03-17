public class MaxConsOnes_LC485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0] == 0 ? 0 : 1;
        int maxLen = 0, oneCount = 0;
        // 0 0 1 1 0 -
        // 1 1 0 1 1
        // 0 0 0 0 0
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                oneCount = 0;
            } else {
                oneCount++;
            }
            // Be very critical of adjusting max in each step
            // or else the last element will not be taken into consideration
            maxLen = Math.max(maxLen, oneCount);
        }
        return maxLen;
    }
}

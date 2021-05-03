public class ProdOfArrExceptSelf_LC238 {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            output[i] *= nums[i + 1];
            nums[i] *= nums[i + 1];
        }
        return output;
    }
}
/**
 * This is a scam problem. 
 * I use the input array as the R suffix array. HAHA HAHA!!!!
 */
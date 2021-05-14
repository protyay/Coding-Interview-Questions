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


    public int[] productExceptSelf_WithoutMutatingInp(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int r = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            res[i] *= r;
            r *= nums[i];
        }
        return res;
    }
}
/**
 * This is a scam problem. I use the input array as the R suffix array. HAHA
 * HAHA!!!!
 */
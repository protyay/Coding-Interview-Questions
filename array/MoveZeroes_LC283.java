public class MoveZeroes_LC283 {
    public void moveZeroes(int[] nums) {
        int swapIdx = 0;
        for(int i = 0 ; i < nums.length; i++){
          if(nums[i] == 0) continue;
          nums[swapIdx++] = nums[i];
        }
      
        for(int i = swapIdx; i < nums.length; i++){
          nums[i] = 0;
        }
    }
}

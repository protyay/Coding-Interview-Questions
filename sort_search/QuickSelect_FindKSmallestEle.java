import java.util.Random;

public class QuickSelect_FindKSmallestEle {

    public int quickSelect(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        
        return quickSelect(nums, k , lo, hi);
    }

    private int quickSelect(int[] nums, int k, int lo, int hi) {
        int pivot = nums[hi];
        int pivotIndex = partition(nums, pivot, lo, hi);
        
        return 0;
    }

    private int partition(int[] nums, int pivot, int lo, int hi) {
        System.out.println("Pivot ="+pivot);
        int i = lo, j = lo;
        while(i <= hi){
            
        }
        return 0;
    }

    private void swap(int[] nums, int from, int to) {
        if (from == to)
            return;
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}

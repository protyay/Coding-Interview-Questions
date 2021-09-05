import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three3Sum_LC15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 3) return ans;
        //[1,0,-1,-2,3] --> -2,-1,0,1,3
        Arrays.sort(nums);
        
        // The key idea is for each nums[i], we check if there are two numbers that sums upto 0.
        for(int i = 0 ; i < nums.length;){
            // Make sure we fulfill the criteria where i != j,  j != k and i != k
            int start = i + 1, end = nums.length - 1;
            int a = nums[i];
            while(start < end){
                int b = nums[start], c = nums[end];
                int sum = a + b + c;
                
                if(sum < 0){
                    start++;
                }
                else if(sum > 0) end--;
                else {
                    List<Integer> validTriplet = List.of(a, b, c);
                    ans.add(validTriplet);
                    start++;
                    while(start < end && nums[start] == nums[start - 1]) start++;
                    --end;
                    while(end > start && nums[end] == nums[end + 1]) end--;
                }
            }
            i++;
            while(i < nums.length && nums[i-1] == nums[i])i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4} ;
        var res = threeSum(input);
        System.out.println("Result = "+ res);
    }
}

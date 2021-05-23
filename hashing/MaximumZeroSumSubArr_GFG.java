import java.util.HashMap;
import java.util.Map;

public class MaximumZeroSumSubArr_GFG {
    int maxLen(int arr[], int n)
    {
        // Your code here
        // For calculating largest subarray with zero sum
        // we follow subarray sum pattern
        // for each index, check if there's a possible subarray ending at curr
        // index whose sum is zero. If yes, record the sum
        int sum = 0, maxLen = 0;
        Map<Integer, Integer> prefixIndex = new HashMap<>();
        
        for(int i = 0 ; i < arr.length; i++){
            sum += arr[i];
            // If we have a zero sum array, we update the maxLen
            if(sum == 0){
                maxLen = Math.max(i+1, maxLen);
            }
            else {
                if(prefixIndex.containsKey(sum)){
                    maxLen = Math.max(i - prefixIndex.get(sum), maxLen);
                }
                else{
                    prefixIndex.put(sum, i);
                }
            }
        }
        return maxLen;
    }
}
/**
 * https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
 * 
 * This is a wonderful problem. Classic application of prefix sum and hash-table
 */

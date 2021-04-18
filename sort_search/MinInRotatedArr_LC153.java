public class MinInRotatedArr_LC153 {
    public int findMin(int[] nums) {
        // We have unique elements
        // If the array is rotated, then nums[0] > nums[end]

        int start = 0, end = nums.length - 1;
        // TC - [1], [4,5,1,2,3]
        while (start < end && nums[start] > nums[end]) {
            ++start;
        }
        return nums[start];
    }
}
/**
 * Wonderful problem based on the Binary Search intuition
 * This is very similar to the adjustmnet we made in the code
 * LC_81 code from LC33 code. 
 * Adjust the starting 
 */

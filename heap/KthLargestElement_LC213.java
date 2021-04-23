import java.util.*;

public class KthLargestElement_LC213 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() == k) {
                if (minHeap.peek() < nums[i]) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            } else {
                minHeap.add(nums[i]);
            }
        }
        return minHeap.poll();
    }

}
/**
 * Choosing a max-heap or min-heap is often times confusing. 
 * 
 * The framework
 * useful for thinking is to understand what kind of values would violate my
 * current assumption.
 * 
 * Let's say we have elements [2,3] and we are asked to
 * return always the 2nd LARGEST element in the stream/array. So the
 * current 2nd largest is 2. The next element we encounter in the stream might
 * be < or > 2. 
 * If the number is less than 2, then it doesn't violates
 * the current assumption SINCE, the K-TH LARGEST element is DEPENDENT ONLY on
 * the elements LARGER THAN 2. If we do not encounter a better value, then our
 * assumption holds and the current 2nd LARGEST candidate won't change.
 */

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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement_LC496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // We encode the number in nums2 into a stack.
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> nextG = new HashMap<>();

        for (int n : nums2) {
            if (stack.isEmpty() || n <= stack.getFirst()) {
                stack.addFirst(n);
            } else {
                while (!stack.isEmpty() && n > stack.getFirst()) {
                    nextG.put(stack.removeFirst(), n);
                }
                stack.addFirst(n);
            }
        }
        while (!stack.isEmpty()) {
            nextG.put(stack.removeFirst(), -1);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for (int n : nums1) {
            res[index++] = nextG.get(n);
        }
        return res;
    }
}
/**
 * Build a monotonically decreasing stack[FROM TOP to BOTTOM]
 */

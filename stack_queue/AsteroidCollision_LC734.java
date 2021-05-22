import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision_LC734 {
    /**
     * This problem also appears as Space Battle in Binary Search
     * @param nums
     * @return
     */
    public int[] solve(int[] nums) {
        if (nums.length == 1)
            return nums;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums) {
            if (!stack.isEmpty()) {
                int top = 0;
                while (!stack.isEmpty() && stack.getFirst() > 0 && num < 0 && Math.abs(top) != Math.abs(num)) {
                    if (Math.abs(stack.getFirst()) <= Math.abs(num))
                        top = stack.removeFirst();
                    else {
                        top = num;
                        break;
                    }
                }
                if (Math.abs(top) != Math.abs(num))
                    stack.addFirst(num);
            } else
                stack.addFirst(num);
        }

        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.removeLast();
        }
        return res;
    }
}
/**
 * Approach - 
 * Keep in mind that the collision only occurs when both are
 * APPROACHING each other. If the stack top has a NEGATIVE element, with the
 * current a positive element, they are going in Opposite direction This is NOT
 * entirely intuitive at the first go.
 * 
 * Also, when the collision chain is completed, we have a choice whether we will add the current element to the stack.
 * 
 * If the last collision result was AN Equal collision, we avoid processing further because both of the element(s) have been
 * destroyed.
 */

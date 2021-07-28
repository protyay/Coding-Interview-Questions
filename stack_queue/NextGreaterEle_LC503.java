import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterEle_LC503 {
    // SDE problem
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.getFirst()] < num) {
                next[stack.removeFirst()] = num;
            }
            if (i < n)
                stack.push(i);
        }
        return next;
    }
}

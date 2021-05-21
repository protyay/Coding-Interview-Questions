import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemp_LC739 {
    // SDE problem Repeat
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty() || T[i] <= T[stack.getFirst()]) {
                stack.addFirst(i);
            } else {
                while (!stack.isEmpty() && T[i] > T[stack.getFirst()]) {
                    int prev = stack.removeFirst();
                    res[prev] = i - prev;
                }
                stack.addFirst(i);
            }
        }
        return res;
    }
}
/**
 * [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0,
 * 0]. The concept of Monotonically decreasing stack(or Increasing stack, based
 * on scenario) The invariant is to store elements which are mono-inc/dec and
 * while the pattern is violated update all the previously affected elements and
 * restore invariant. Insert the current element.
 */
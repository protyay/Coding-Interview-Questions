import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWinMax_LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1)
            return nums;

        Deque<Integer> deq = new ArrayDeque<>();
        int N = nums.length;
        List<Integer> res = new ArrayList<>();  

        for (int l = 0, r = 0; r < N; r++) {
            while (!deq.isEmpty() && nums[deq.getLast()] < nums[r]) {
                deq.removeLast();
            }
            deq.addLast(r);
            if (r - l + 1 == k) {
                res.add(nums[deq.getFirst()]);
                if (deq.getFirst() == l)
                    deq.removeFirst();
                l++;
            }
        }
        int[] ans = res.stream().mapToInt(i -> i).toArray();
        return ans;
    }
}

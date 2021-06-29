import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRecInHistogram_LC84 {
    // SDE
    public int largestRectangleArea_bruteForce(int[] heights) {
        int maxArea = heights[0];
        if (heights.length == 1)
            return maxArea;

        for (int i = 1; i < heights.length; i++) {
            int h = heights[i];
            maxArea = Math.max(h, maxArea);
            for (int j = i - 1; j >= 0; j--) {

                h = Math.min(h, heights[j]);
                int w = i - j + 1;

                maxArea = Math.max(maxArea, h * w);
            }
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] h) {
        Deque<ArrayEntry> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i < h.length; i++) {
            // Monotonic stack behavior
            int index = i;
            while (!stack.isEmpty() && stack.getFirst().val > h[i]) {
                int area = stack.getFirst().val * (i - stack.getFirst().index);
                maxArea = Math.max(maxArea, area);
                index = stack.removeFirst().index;
            }
            stack.addFirst(new ArrayEntry(index, h[i]));
        }
        // Process the rest of the elements in the stack
        while (!stack.isEmpty()) {
            int area = stack.getFirst().val * (h.length - stack.getFirst().index);
            maxArea = Math.max(maxArea, area);
            stack.removeFirst();
        }
        return maxArea;
    }

    class ArrayEntry {
        int val;
        int index;

        ArrayEntry(int i, int v) {
            this.index = i;
            this.val = v;
        }
    }

    public static void main(String[] args) {
        int[] h = { 2, 1, 5, 6, 2, 3 };
        LargestRecInHistogram_LC84 lc84 = new LargestRecInHistogram_LC84();
        int largestRectangleArea = lc84.largestRectangleArea(h);
        System.out.println(largestRectangleArea);
    }
}
// Check all possible pairs for the largest rec.
// Draw a diagram and check possibility
// https://www.youtube.com/watch?v=zx5Sw9130L0

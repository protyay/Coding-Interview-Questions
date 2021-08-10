public class LargestRecInHistogram_LC84 {
    // SDE
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];
        int N = heights.length;

        int[] stack = new int[N + 1];
        stack[0] = -1;// idx = 0 represents stack empty condition

        int idx = 0, res = 0;

        for (int i = 0; i < N; i++) {
            int curr = heights[i];
            while (idx > 0 && heights[stack[idx]] > curr) {
                res = Math.max(res, heights[stack[idx--]] * (i - 1 - stack[idx]));
            }
            stack[++idx] = i;
        }
        while (idx > 0) {
            res = Math.max(res, heights[stack[idx--]] * (N - 1 - stack[idx]));
        }
        return res;
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

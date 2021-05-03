import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_LC58 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Traverse the array in layered manner
        int top = 0, left = 0, right = matrix[0].length, bottom = matrix.length;
        List<Integer> res = new ArrayList<>();
        // It's a wonderful framework. If you have declared the variable names and
        // maintained
        // proper updation at each step. You are through.

        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            ++top; // We are done processing the top row
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            --right; // We are done processing the rightmost column
            // We still have elements left to process
            if (left < right && top < bottom) {

                for (int i = right - 1; i >= left; i--) {
                    res.add(matrix[bottom - 1][i]);
                }
                --bottom; // We are done processing the bottom row
                for (int i = bottom - 1; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                ++left;
            }
        }
        return res;
    }
}
/**
 * Weirdest problem. This pretty much gives an idea of the boundary traversal of
 * the array Traversal of a 2D array would involve processing each side
 * separately
 */
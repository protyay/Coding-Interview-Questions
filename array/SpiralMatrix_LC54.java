import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_LC54 {
    // SDE problem
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return nums;

        int left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1, top = 0;
        int size = matrix.length * matrix[0].length;

        while (nums.size() < size) {
            for (int i = left; i <= right && nums.size() < size; i++) {
                nums.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && nums.size() < size; i++) {
                nums.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && nums.size() < size; i--) {
                nums.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && nums.size() < size; i--) {
                nums.add(matrix[i][left]);
            }
            left++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        SpiralMatrix_LC54 lc54 = new SpiralMatrix_LC54();
        List<Integer> spiralOrder = lc54.spiralOrder(matrix);
        System.out.println(spiralOrder);

    }
}
/**
 * This is not the weirdest problem. This is a four pointer problem. Each corner
 * of the matrix is denoted by four pointers Assign each pointer with corner
 * values Once a layer is traverse make the necessary adjustment and start
 * traversing again
 */
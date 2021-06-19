public class RotateImage_LC48 {
    // SDE
    // Repeat
    public void rotate(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = i; j < c; j++) {
                if(i == j) continue;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < r; i++) {
            int lo = 0, hi = c - 1;
            while (lo < hi) {
                int temp = matrix[i][lo];
                matrix[i][lo] = matrix[i][hi];
                matrix[i][hi] = temp;

                ++lo;
                --hi;
            }
        }
    }
}
// Keep in mind how we transpose the matrix

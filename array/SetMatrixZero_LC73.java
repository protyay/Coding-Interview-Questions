public class SetMatrixZero_LC73 {
    // SDE problem
    // REPEAT
    public void setZeroes(int[][] matrix) {
        // The most optimal solution uses top row and left col as the dummy
        // space. Use indicator with a flag to maintain whether col 0 will be made 0

        boolean col0 = false;
        int r = matrix.length, c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0)
                col0 = true;
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (col0)
                matrix[i][0] = 0;
        }
    }

}

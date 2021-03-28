public class NumOfIslands_BS23 {
    public int solve(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 1) {
                    fillIsland(matrix, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void fillIsland(int[][] matrix, int r, int c) {
        if (r < 0 || r == matrix.length || c < 0 || c == matrix[0].length || matrix[r][c] == 0)
            return;
        matrix[r][c] = 0;
        fillIsland(matrix, r + 1, c);
        fillIsland(matrix, r - 1, c);
        fillIsland(matrix, r, c + 1);
        fillIsland(matrix, r, c - 1);
    }
}

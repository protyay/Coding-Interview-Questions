public class SinkingIslands_BS43 {
    public int[][] solve(int[][] board) {
        // Your essential search space is reduced by one row and one col
        int r = board.length;
        int c = board[0].length;

        // We identify islands connected to border and temporarily invalidate them

        // Traverse the first and the last column
        for (int i = 0; i < r; i++) {
            if (board[i][0] == 1)
                invalidateBorderIsland(board, i, 0);

            if (board[i][c - 1] == 1)
                invalidateBorderIsland(board, i, c - 1);
        }
        // Traverse the first and the last row
        for (int i = 0; i < c; i++) {
            if (board[0][i] == 1)
                invalidateBorderIsland(board, 0, i);

            if (board[r - 1][i] == 1)
                invalidateBorderIsland(board, r - 1, i);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 1)
                    fillWater(i, j, board);
            }
        }

        // Restore the invalidated cells back to 1
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == -2)
                    board[i][j] = 1;
            }
        }
        return board;
    }
    // We recursively visit valid neighbours and invalidate those, if NOT already done
    private void invalidateBorderIsland(int[][] board, int r, int c) {
        if (r < 0 || r == board.length || c < 0 || c == board[0].length || board[r][c] == 0
            || board[r][c] == -2)
            return;

        board[r][c] = -2;

        invalidateBorderIsland(board, r + 1, c);
        invalidateBorderIsland(board, r - 1, c);
        invalidateBorderIsland(board, r, c - 1);
        invalidateBorderIsland(board, r, c + 1);
    }
    private void fillWater(int r, int c, int[][] board) {
        if (r == 0 || r == board.length - 1 || c == 0 || c == board[0].length - 1
            || board[r][c] == 0 || board[r][c] == -2)
            return;
        board[r][c] = 0;
        fillWater(r + 1, c, board);
        fillWater(r - 1, c, board);
        fillWater(r, c + 1, board);
        fillWater(r, c - 1, board);
    }
}

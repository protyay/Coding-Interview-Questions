public class SudokuSolver_LC37 {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.')
                    continue;

                for (char value = '1'; value <= '9'; value++) {

                    if (isValid(board, i, j, value)) {
                        board[i][j] = value;
                        if (solve(board))
                            return true;
                        else
                            board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char value) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value || board[i][col] == value)
                return false;
            int boxR = 3 * (row / 3) + i / 3;
            int boxC = 3 * (col / 3) + i % 3;
            if (board[boxR][boxC] == value)
                return false;
        }
        return true;
    }
}

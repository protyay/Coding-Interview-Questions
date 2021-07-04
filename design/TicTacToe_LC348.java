public class TicTacToe_LC348 {
    /** Initialize your data structure here. */
    private final int[] rows;
    private final int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private final int n;

    public TicTacToe_LC348(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagonal = 0;
        this.antiDiagonal = 0;
        this.n = n;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     * 
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either: 0: No one wins. 1:
     *         Player 1 wins. 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int num = player == 1 ? 1 : -1;
        int target = player == 1 ? n : -n;

        rows[row] += num;
        cols[col] += num;

        if (row == col)
            diagonal += num;
        if (row + col + 1 == this.n)
            antiDiagonal += num;

        if (rows[row] == target || cols[col] == target || diagonal == target || antiDiagonal == target)
            return player;

        return 0;
    }
}

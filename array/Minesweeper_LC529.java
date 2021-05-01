import java.util.Arrays;

public class Minesweeper_LC529 {
    private final int[][] adjacent = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
            { -1, -1 } };
    private int M;
    private int N;

    public char[][] updateBoard(char[][] board, int[] click) {

        int posX = click[0], posY = click[1];
        // Early return for when the clicked cell is a MINE
        if (board[posX][posY] == 'M') {
            board[posX][posY] = 'X';
            return board;
        }
        int M = board.length, N = board[0].length;
        this.M = M;
        this.N = N;

        dfs(board, posX, posY);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        if (!isInMatrix(x, y) || board[x][y] != 'E')
            return;
        int mines = this.fetchAdjMines(x, y, board);
        if (mines > 0) {
            // We stop visiting neighbours if the current cell has a neighbouring MINE
            board[x][y] = (char) (mines + '0');
        } else {
            //
            board[x][y] = 'B';

            int r = 0, c = 0;
            for (int[] loc : this.adjacent) {
                r = x + loc[0];
                c = y + loc[1];
                dfs(board, r, c);
            }
        }
    }

    private int fetchAdjMines(int x, int y, char[][] board) {
        int r = 0, c = 0;
        int mines = 0;
        for (int[] loc : this.adjacent) {
            r = x + loc[0];
            c = y + loc[1];
            // If the neighbour is in the matrix boundary and it's a MINE
            if (isInMatrix(r, c) && (board[r][c] == 'M' || board[r][c] == 'X'))
                ++mines;
        }
        return mines;
    }

    private boolean isInMatrix(int r, int c) {
        if (r < 0 || r >= this.M || c < 0 || c >= this.N)
            return false;

        return true;
    }

    public static void main(String[] args) {
        Minesweeper_LC529 lc529 = new Minesweeper_LC529();
        char[][] board = { { 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'M', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E' },
                { 'E', 'E', 'E', 'E', 'E' } };
        char[][] ans = lc529.updateBoard(board, new int[] { 3, 0 });
        System.out.println(Arrays.deepToString(ans));
    }
}
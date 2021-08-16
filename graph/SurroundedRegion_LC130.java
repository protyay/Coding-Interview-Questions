public class SurroundedRegion_LC130 {
    private final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = new boolean[r][c];

        // Traverse the first row and last row
        for (int i = 0; i < c; i++) {
            if (board[0][i] == 'O')
                dfs(board, 0, i, visited);
            if (board[r - 1][i] == 'O')
                dfs(board, r - 1, i, visited);
        }
        // Traverse the first col and the last col
        for (int i = 0; i < r; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0, visited);
            if (board[i][c - 1] == 'O')
                dfs(board, i, c - 1, visited);
        }
        // Restore the marker values to O and rest values to X
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'K')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

    // This dfs marks every O connected to the boundary as K
    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        board[i][j] = 'K';

        for (int[] d : DIRS) {
            int dx = d[0] + i;
            int dy = d[1] + j;

            if (!isInMatrix(board, dx, dy) || visited[dx][dy] || board[dx][dy] != 'O')
                continue;
            dfs(board, dx, dy, visited);
        }
    }

    private boolean isInMatrix(char[][] board, int dx, int dy) {
        if (dx < 0 || dx >= board.length || dy < 0 || dy >= board[0].length)
            return false;
        return true;
    }
}

public class WordSearch_LC79 {
    private final int[][] xy = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        int r = board.length, c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == word.charAt(0) && exists(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean exists(char[][] board, String word, int index, int r, int c) {
        if (index == word.length() - 1 && board[r][c] == word.charAt(index))
            return true;

        // We need to handle the case to change the char
        if (board[r][c] != word.charAt(index))
            return false;
        char temp = board[r][c];

        board[r][c] = '*';

        for (int[] dir : this.xy) {
            int rA = dir[0] + r;
            int cA = dir[1] + c;
            if (isInMatrix(board, rA, cA) && exists(board, word, index + 1, rA, cA))
                return true;
        }
        board[r][c] = temp;
        return false;

    }

    private boolean isInMatrix(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length)
            return false;
        return true;
    }

}
/**
 * The time complexity is a little tricky- TC - O(N.3^L) - N is the number of
 * cells, L is the length of the word to be matched SC - If we don't include the
 * recursion stack, it's constant space solution
 */

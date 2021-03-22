public class WordSearch_LC79 {
    public boolean exist(char[][] board, String word) {
        if (board == null || word.isEmpty())
            return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && findStr(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findStr(char[][] board, int r, int c, int count, String word) {
        if (count == word.length())
            return true;

        if (r < 0 || r == board.length || c < 0 || c == board[0].length || board[r][c] != word.charAt(count))
            return false;

        char temp = board[r][c];
        board[r][c] = '*';
        // If either one of these calls result in true, we skip all calls; // May be
        // this is pruning ?
        boolean found = findStr(board, r + 1, c, count + 1, word) || findStr(board, r - 1, c, count + 1, word)
                || findStr(board, r, c + 1, count + 1, word) || findStr(board, r, c - 1, count + 1, word);
        board[r][c] = temp;
        return found;
    }

}

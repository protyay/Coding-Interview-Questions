public class ValidSudoku_LC36 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> rowCache = new HashSet<>();
        Set<String> colCache = new HashSet<>();
        Set<String> boardCache = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                String ele = String.valueOf(board[i][j]);
                String rowKey = ele + i, colKey = ele + j, boardKey = ele + i / 3 + j / 3;
                if (!rowCache.add(rowKey) || !colCache.add(colKey) || !boardCache.add(boardKey))
                    return false;
            }
        }
        return true;
    }
}

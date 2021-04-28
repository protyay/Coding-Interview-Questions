import java.util.Map;

public class UnidirStrSearch_BS37 {

    public boolean solve(String[][] board, String word) {
        // At each index, we have two choices
        Map<String, Boolean> target = Map.of(word, true);
        StringBuilder str = new StringBuilder();

        int r = board.length, c = board[0].length;

        int k = 0;
        // Apply two pointer on the board both row-wise and col-wise
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (str.length() < word.length()) {
                    str.append(board[i][j]);
                } else {
                    if (target.containsKey(str.toString()))
                        return true;
                    str.deleteCharAt(k);
                    str.append(board[i][j]);
                    k++;
                }
            }
        }
        for (int i = 0; i < c;) {
            for (int j = 0; j < r; j++) {
                if (j - i < word.length()) {
                    str.append(board[i][j]);
                    continue;
                }
                if (target.containsKey(str.toString()))
                    return true;
                str.deleteCharAt(i++);
                str.append(board[i][j]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UnidirStrSearch_BS37 bs = new UnidirStrSearch_BS37();
        String[][] board = { { "H", "E", "L", "L", "O", "B", "I", "K", "A" },
                { "A", "B", "C", "D", "E", "U", "N", "I", "K" } };
        boolean ans = bs.solve(board, "LLOB");
        System.out.println("Ans = " + ans);
    }
}

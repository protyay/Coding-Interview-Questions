public class UnidirStrSearch_BS37 {

    public boolean solve(String[][] board, String word) {
        StringBuilder str = null;
        for (int i = 0; i < board.length; i++) {
            str = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                str.append(board[i][j]);
                if (str.toString().contains(word))
                    return true;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            str = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                str.append(board[j][i]);
                if (str.toString().contains(word))
                    return true;
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
/**
 * The running time for this algorithm is a bit tricky.
 * This runs in O(M*N*K) + O(M*N*K) time. 
 * this k factor is introduced for contains 
 */
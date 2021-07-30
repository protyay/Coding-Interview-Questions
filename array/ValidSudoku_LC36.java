import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_LC36 {
    // SDE problem
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i = 0 ; i < 9; i++){
            for(int j = 0 ; j < 9; j++){
                if(board[i][j] == '.') continue;
                int boxId = (i/3)*3 + (j/3);
                if(!seen.add("row"+i+board[i][j]) || !seen.add("col"+j+board[i][j]) || !seen.add("box"+boxId+board[i][j])) return false;
            }
        }
            return true;
    }
}
/**
 * Most important part of the problem is to understand the formulae for
 * calculating index of 3*3 box. That's the most important takeaway
 */

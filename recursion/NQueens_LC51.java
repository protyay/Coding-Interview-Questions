import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens_LC51 {
    // SDE problem
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        List<Integer> placements = new ArrayList<>();
        nQueenRecurse(0, new ArrayList<String>(Collections.nCopies(n, "....")), n, res, placements);
        return res;
    }

    private void nQueenRecurse(int row, List<String> positionStr, int n, List<List<String>> res,
            List<Integer> placements) {
        if (n == row) {
            res.add(new ArrayList<>(positionStr));
            return; // backtrack
        }
        for (int col = 0; col < n; col++) {
            placements.add(col);
            if (isValidPlacement(row, placements)) {
                // Build the locationString
                StringBuilder qLocation = new StringBuilder(".".repeat(n));
                qLocation.setCharAt(col, 'Q');

                positionStr.set(row, qLocation.toString());
                nQueenRecurse(row + 1, positionStr, n, res, placements);
            }
            placements.remove(placements.size() - 1);
        }
    }

    private boolean isValidPlacement(int currentRow, List<Integer> previousPlacements) {
        for (int i = 0; i < currentRow; i++) {
            int diff = Math.abs(previousPlacements.get(i) - previousPlacements.get(currentRow));
            // Column Conflict & Diagonal conflict check
            if (diff == 0 || diff == currentRow - i)
                return false;
        }
        return true;
    }
}
/**
 * One of the most important problem.
 * 
 */

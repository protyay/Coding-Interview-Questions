import java.util.*;

public class RottenOranges_LC994 {
    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        RottenOranges_LC994 lc994 = new RottenOranges_LC994();
        int time = lc994.orangesRotting(grid);
        System.out.println(time);

    }

    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    minutes += startRot(grid, i, j);
                }
            }
        }
        // We re-iterate the matrix to make sure there are NO DISCONNECTED components
        // that consists of a fresh orange.
        // If we encounter, then we return 0, else we return the total minutes recorded
        // to rot each orange in the previous orange
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return 0;
            }
        }
        return minutes;
    }

    private int startRot(int[][] grid, int currR, int currC) {
        int row = grid.length;
        int col = grid[0].length;
        int min = 0;
        Deque<OrangeInfo> oranges = new ArrayDeque<>();
        oranges.addLast(new OrangeInfo(currR, currC));
        grid[currR][currC] = 3;
        while (!oranges.isEmpty()) {
            // We traverse the connected graph in BFS manner

            int size = oranges.size();
            while (size-- > 0) {

                OrangeInfo cell = oranges.removeFirst();
                int r = cell.r;
                int c = cell.c;

                // Add all valid neighbour oranges, if
                // a. They are NOT Rotten itself (Avoid visiting duplicate nodes)
                // b. They are fresh
                // c. They are NOT empty cells
                if (r + 1 < row && grid[r + 1][c] != 3 && grid[r + 1][c] != 0) {
                    oranges.addLast(new OrangeInfo(r + 1, c));
                    grid[r + 1][c] = 3;
                }
                if (c + 1 < col && grid[r][c + 1] != 3 && grid[r][c + 1] != 0) {
                    oranges.addLast(new OrangeInfo(r, c + 1));
                    grid[r][c + 1] = 3;
                }
                if (c - 1 >= 0 && grid[r][c - 1] != 3 && grid[r][c - 1] != 0) {
                    oranges.addLast(new OrangeInfo(r, c - 1));
                    grid[r][c - 1] = 3;
                }
                if (r - 1 >= 0 && grid[r - 1][c] != 3 && grid[r - 1][c] != 0) {
                    oranges.addLast(new OrangeInfo(r - 1, c));
                    grid[r - 1][c] = 3;
                }
            }
            if (!oranges.isEmpty())
                ++min;
        }
        return min;
    }

}

class OrangeInfo {
    public int r;
    public int c;

    public OrangeInfo(final int r, final int c) {
        this.r = r;
        this.c = c;
    }
}
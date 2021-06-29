package bfs;

import java.util.*;

public class RottenOranges_LC994 {
    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        Deque<Cell> q = new ArrayDeque<>();

        int r = grid.length, c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.add(new Cell(i, j));
                }
            }
        }

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Cell temp = q.removeFirst();

                grid[temp.x][temp.y] = 3;// very important step

                for (int[] d : dir) {
                    int dx = temp.x + d[0];
                    int dy = temp.y + d[1];

                    if (isInMatrix(grid, dx, dy) && grid[dx][dy] == 1 && !visited[dx][dy]) {
                        visited[dx][dy] = true;// this is very important step wherein if we add a neighbour we mark it
                        // as visited to avoid duplicate addition
                        q.addLast(new Cell(dx, dy));
                    }

                }
            }
            if (q.isEmpty())
                break;
            ++time;
        }
        if (!isAllRotten(grid))
            return -1;
        return time;
    }

    private boolean isInMatrix(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return false;
        return true;
    }

    private boolean isAllRotten(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return false;
            }
        }
        return true;
    }
}

class Cell {
    int x;
    int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
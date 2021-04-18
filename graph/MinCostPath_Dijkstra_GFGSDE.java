import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostPath_Dijkstra_GFGSDE {
    public int minimumCostPath(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        Queue<Cell> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // There's a cost associated with reaching each step
        int[][] cost = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        boolean[][] visited = new boolean[r][c];
        Cell source = new Cell(0, 0, grid[0][0]);
        minHeap.add(source);// Add the source cell value;
        visited[0][0] = true;
        // Set the starting cost
        cost[0][0] = grid[0][0];
        // We start the relaxation process
        while (!minHeap.isEmpty()) {
            int size = minHeap.size();
            while (size-- > 0) {

                Cell currNode = minHeap.remove();

                int x = currNode.x, y = currNode.y;

                if (x + 1 < r && !visited[x + 1][y]) {

                    // Relax the edge - d[v] > d[u] + w(u,v)-> Update d[v]
                    if (cost[x + 1][y] > cost[currNode.x][currNode.y] + grid[x + 1][y]) {
                        cost[x + 1][y] = cost[currNode.x][currNode.y] + grid[x + 1][y];
                        Cell down = new Cell(x + 1, y, cost[x + 1][y]);
                        visited[x + 1][y] = true;
                        minHeap.add(down);
                    }

                }
                if (y + 1 < c && !visited[x][y + 1]) {
                    if (cost[x][y + 1] > cost[currNode.x][currNode.y] + grid[x][y + 1]) {
                        cost[x][y + 1] = cost[currNode.x][currNode.y] + grid[x][y + 1];
                        Cell right = new Cell(x, y + 1, cost[x][y + 1]);
                        visited[x][y + 1] = true;
                        minHeap.add(right);
                    }
                }
                if (x - 1 >= 0 && !visited[x - 1][y]) {
                    if (cost[x - 1][y] > cost[currNode.x][currNode.y] + grid[x - 1][y]) {
                        cost[x - 1][y] = cost[currNode.x][currNode.y] + grid[x - 1][y];
                        Cell top = new Cell(x - 1, y, cost[x - 1][y]);
                        visited[x - 1][y] = true;
                        minHeap.add(top);
                    }
                }
                if (y - 1 >= 0 && !visited[x][y - 1]) {
                    if (cost[x][y - 1] > cost[currNode.x][currNode.y] + grid[x][y - 1]) {
                        cost[x][y - 1] = cost[currNode.x][currNode.y] + grid[x][y - 1];
                        Cell left = new Cell(x, y - 1, cost[x][y - 1]);
                        visited[x][y - 1] = true;
                        minHeap.add(left);
                    }
                }
            }
        }
        return cost[r - 1][c - 1];
    }

    class Cell {
        int x;
        int y;
        int val;

        Cell(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.val = value;
        }
    }

    public static void main(String[] args) {
        MinCostPath_Dijkstra_GFGSDE gfgsde = new MinCostPath_Dijkstra_GFGSDE();
        int[][] grid = { { 9, 4, 9, 9 }, { 6, 7, 6, 4 }, { 8, 3, 3, 7 }, { 7, 4, 9, 10 } };
        int minCostPath = gfgsde.minimumCostPath(grid);
        System.out.println("Min cost from S to D =" + minCostPath);
    }
}

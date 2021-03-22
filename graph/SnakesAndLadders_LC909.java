import java.util.ArrayDeque;
import java.util.Deque;

public class SnakesAndLadders_LC909 {
  public int snakesAndLadders(int[][] board) {
    // Check if the destination co-ordinates doesn't have a snake.
    if (board[0][0] != -1)
      return -1;
    int n = board.length;
    Deque<Integer> pos = new ArrayDeque<>();
    boolean[][] visited = new boolean[n][n];
    int steps = 0;
    pos.addLast(1);
    visited[n - 1][0] = true;
    while (!pos.isEmpty()) {
      int size = pos.size();
      while (size-- > 0) {
        int currVal = pos.removeFirst();
        if (currVal == n * n)
          return steps;

        // Visit all the neighbours
        for (int i = 1; i <= 6; i++) {
          if (currVal + i > n * n)
            break;

          int[] location = calcLocation(currVal + i, n);
          int r = location[0], c = location[1];
          if (visited[r][c])
            continue;
          visited[r][c] = true;
          if (board[r][c] == -1)
            pos.addLast(currVal + i);
          else
            pos.addLast(board[r][c]);
        }
      }
      ++steps;
    }
    return steps;
  }

  private int[] calcLocation(int currVal, int boardSize) {
    // Determine whether the value is in odd row or not
    int q = (currVal - 1) / boardSize;
    int r = (currVal - 1) % boardSize;
    int row = boardSize - 1 - q;
    int col = q % 2 == 0 ? r : boardSize - 1 - r;

    return new int[] { row, col };
  }
}

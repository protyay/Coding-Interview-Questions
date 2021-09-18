public class FloodFill_LC733 {
    final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        dfs(sr, sc, image, newColor, oldColor);
        return image;
    }

    private void dfs(int x, int y, int[][] image, int newColor, int oldColor) {
        if (image[x][y] != oldColor)
            return;

        image[x][y] = newColor;
        for (int[] dir : DIRS) {
            int dx = dir[0] + x;
            int dy = dir[1] + y;

            if (!inMatrix(image, dx, dy))
                continue;
            if (image[dx][dy] == newColor)
                continue;

            dfs(dx, dy, image, newColor, oldColor);
        }
    }

    private boolean inMatrix(int[][] image, int x, int y) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length)
            return false;
        return true;
    }
}

public class FlyodWarshall_GFG {
    private final int MAX = Integer.MAX_VALUE;

    public void shortest_distance(int[][] matrix) {
        int N = matrix.length;
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // If the distance between two vertex is NOT yet decided , skip the calculation
                    if (matrix[i][k] == MAX || matrix[k][j] == MAX)
                        continue;
                    // If there's NO edge between two vertices, skip the calculation
                    if (matrix[i][k] == -1 || matrix[k][j] == -1)
                        continue;

                    if (matrix[i][k] + matrix[k][j] < matrix[i][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }
    }
}

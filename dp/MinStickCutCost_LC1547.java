public class MinStickCutCost_LC1547 {
    int cost = Integer.MAX_VALUE;

    public int minCost(int n, int[] cuts) {
        if (cuts.length == 1)
            return n;
        boolean[] visited = new boolean[cuts.length];
        solve(n, cuts, 0, visited);
        return cost;
    }

    private void solve(int length, int[] cuts, int pathCost, boolean[] visited) {
        if (isAllCutsComplete(visited)) {
            cost = Math.min(pathCost, cost);
            return;
        }
        for (int i = 0; i < cuts.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            solve(length - cuts[i], cuts, pathCost + length, visited);
            visited[i] = false;
        }
    }

    private boolean isAllCutsComplete(boolean[] visited) {
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i])
                ++count;
        }
        return count == visited.length;
    }
    public static void main(String[] args) {
        MinStickCutCost_LC1547 lc1547 = new MinStickCutCost_LC1547();
        int[] cuts = {1,3,5,4};
        int n = 7;

    }
}
/**
 * Incomplete
 */

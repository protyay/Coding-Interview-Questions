public class PascalsTriangle_BS123 {
    public int[] solve(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 1;
        int k = 1;
        while (k <= n) {
            for (int i = ans.length - 1; i > 0; i--) {
                ans[i] += ans[i - 1];
            }
            ++k;
        }
        return ans;
    }
}
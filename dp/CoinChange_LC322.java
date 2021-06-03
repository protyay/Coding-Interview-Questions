import java.util.Arrays;

public class CoinChange_LC322 {
    // SDE problem - Unbounded Knapsack - Bottom Up way
    // TC - O(S*N) - S= Amount, N = Total Denominations of Coins array
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // We are trying to build all possible denomination
                if (coin > i)
                    continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
class CoinChange_TopDown {
    private Integer[] dp;
    public int coinChange(int[] coins, int amount){
        dp = new Integer[amount + 1];
        return dfs(coins, amount);
    }
    private int dfs(int[] coins, int remain){
        if(remain == 0) return 0;
        
    }
}

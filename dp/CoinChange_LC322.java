import java.util.Arrays;

public class CoinChange_LC322 {
    // SDE problem - Unbounded Knapsack - Bottom Up way
    // TC - O(S*N) - S= Amount, N = Total Denominations of Coins array
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (c > i || dp[i - c] == Integer.MAX_VALUE)
                    continue;
                dp[i] = Math.min(dp[i - c] + 1, dp[i]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

class CoinChange_TopDown {
    Integer[] dp = new Integer[1_000_1];

    public int coinChange(int[] coins, int amount) {
        int minCoins = dfs(coins, amount);
        return minCoins;
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (dp[amount] != null)
            return dp[amount];

        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            int cc = dfs(coins, amount - c);
            if (cc == -1)
                continue;
            min = Math.min(cc + 1, min);
        }
        return dp[amount] = min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        CoinChange_TopDown td = new CoinChange_TopDown();
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        int ans = td.coinChange(coins, amount);
        System.out.println("Ans = " + ans);
    }

}

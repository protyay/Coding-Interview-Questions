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
    public int coinChange(int[] coins, int amount) {
        int minCoins = dfs(coins, amount);
        return minCoins;
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            int cc = dfs(coins, amount - c);
            if (cc == -1)
                continue;
            min = Math.min(cc + 1, min);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        CoinChange_TopDown td = new CoinChange_TopDown();
        int[] coins = { 1,2,5 };
        int amount = 11;
        int ans = td.coinChange(coins, amount);
        System.out.println("Ans = " + ans);
    }

}

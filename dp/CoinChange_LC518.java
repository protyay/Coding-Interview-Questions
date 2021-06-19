public class CoinChange_LC518 {
    // SDE V.V. Important - Combination problem
    private int ans = 0;

    public int change(int amount, int[] coins) {
        change(amount, coins, 0);
        return ans;
    }

    private void change(int amount, int[] coins, int index) {
        if (amount == 0) {
            ++ans;
            return;
        }
        for (int i = index; i < coins.length; i++) {
            if (amount - coins[i] < 0)
                continue;
            change(amount - coins[i], coins, i);
        }
    }
}

class Unbounded_Knapsack {
    public int change(int amount, int[] coins) {
        if (amount == 0)
            return 1;

        Integer[][] dp = new Integer[amount + 1][coins.length];
        return change(amount, coins, 0, dp);
    }

    private int change(int amount, int[] coins, int index, Integer[][] dp) {
        if (amount == 0)
            return 1;
        if (amount < 0 || index >= coins.length)
            return 0;
        if (dp[amount][index] != null)
            return dp[amount][index];

        int select = change(amount - coins[index], coins, index, dp);
        int reject = change(amount, coins, index + 1, dp);

        dp[amount][index] = select + reject;
        return dp[amount][index];
    }
}

class BottomUp_DP {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;// base-case
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Arrays.sort(coins);
        if (coins[0] > amount) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int coin : coins) {
            if (coin <= amount)
                dp[coin] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin > 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
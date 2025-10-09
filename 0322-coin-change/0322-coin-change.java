class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];// dp[i] means the number of coins to make up i
        Arrays.fill(dp,amount+1); //초기화
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > amount) break;
            dp[coin] = 1;
        }
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                //System.out.printf("dp[%d] = Math.min(%d,%d)\n", i, dp[i-coin] + 1, dp[i]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
/**

 */
class Solution {
    public int maxProfit(int[] prices) {
        int cheapiest = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int p : prices) {
            cheapiest = Math.min(cheapiest, p);
            maxProfit = Math.max(maxProfit, p - cheapiest);
        }
        return maxProfit;
    }
}
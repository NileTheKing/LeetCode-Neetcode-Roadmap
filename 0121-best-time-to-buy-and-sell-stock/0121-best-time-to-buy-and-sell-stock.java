class Solution {
    public int maxProfit(int[] prices) {
        //싸게사서 비싸게 팔면 좋다.
        //각 날짜에서 제일 싸게살수 있을때가 언제잉ㄴ지 (왼쪽)
        //랑 오른쪽바라볼떄 제일 비싼가격이 뭔지.
        int len = prices.length;
        int[] cheap = new int[len];
        int[] expensive = new int[len];
        int cheapiest = Integer.MAX_VALUE;
        int mostExpensive = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            cheap[i] = Math.min(cheapiest, prices[i]);
            cheapiest = Math.min(cheapiest, cheap[i]);
            // System.out.printf("%d, %d\n", i, cheap[i]);
        }
        for (int i = len - 1; i >= 0; i--) {
            expensive[i] = Math.max(mostExpensive, prices[i]);
            mostExpensive = Math.max(mostExpensive, expensive[i]);
            // System.out.printf("%d, %d\n", i, expensive[i]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            // System.out.printf("%d %d\n", cheap[i], expensive[i]);
            ans = Math.max(ans, expensive[i] - cheap[i]);
        }
        return ans;
    }
}
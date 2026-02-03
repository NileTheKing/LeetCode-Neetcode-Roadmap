class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int len = nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;

    }
}
/**
재활용 가능?
모두 1로 초기화
매번 앞에부터.

 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // System.out.printf("i:%d, j:%d ", i, j);
                    // System.out.printf("dp[%d] = Math.max(%d + 1, %d)\n", i, dp[j], dp[i]);
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
/**
문제를 분해가능
    각 인덱스에서 포함시킬지 안포함시킬지로.
        -> 둘다 관리하면 된다
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        //dp[i] 는 i전까지 길이? 이거는 근데 점화식이 딱히.. 1이니까 할 필요가 없지 않나?

        for (int i = 0; i < nums.length; i++) { //i는 nums인덱스
            for (int j = 0; j < i; j++) {
                //System.out.printf("i,j: %d %d\n", i,j);
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
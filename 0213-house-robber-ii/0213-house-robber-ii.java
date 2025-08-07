class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int[] robbed = new int[n];
        int[] passed = new int[n];
        robbed[0] = nums[0];
        passed[0] = 0;
        robbed[1] = nums[1];
        passed[1] = robbed[0];

        for (int i = 2; i < n - 1; i++) {
            passed[i] = Math.max(passed[i-1], robbed[i-1]);
            robbed[i] = Math.max(robbed[i-2] + nums[i], passed[i-1] + nums[i]);
        }
        
        
        //////
        if (n <= 3) return Arrays.stream(nums).max().getAsInt();
        int[] robbed2 = new int[n];
        int[] passed2 = new int[n];

        robbed2[1] = nums[1];
        passed2[1] = 0;
        robbed2[2] = nums[2];
        passed2[2] = robbed2[1];

        for (int i = 3; i < n; i++) {
            passed2[i] = Math.max(passed2[i-1], robbed2[i-1]);
            robbed2[i] = Math.max(robbed2[i-2] + nums[i], passed2[i-1] + nums[i]);
        }
        
        return Math.max(
            Math.max(passed[n-2], robbed[n-2]), 
            Math.max(passed2[n-1], robbed2[n-1])
        );
    }
}
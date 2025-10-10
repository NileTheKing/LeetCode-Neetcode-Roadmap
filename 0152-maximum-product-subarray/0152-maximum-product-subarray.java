class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int ans = max;
        for (int i = 1; i < nums.length; i++) {
            int tempMin=min;
            min = Math.min(Math.min(min * nums[i], nums[i]), max * nums[i]);
            max = Math.max(Math.max(max * nums[i], nums[i]), tempMin * nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;

    }
}
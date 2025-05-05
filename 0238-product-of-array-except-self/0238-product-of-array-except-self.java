class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        int[] suffix = new int[length];

        prefix[0] = 1;
        prefix[1] = nums[0];
        for (int i = 2; i < length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[length - 1] = 1;
        suffix[length - 2] = nums[length - 1];
        for (int i = 2; i < length; i++) {
            suffix[length - 1 - i] = suffix[length - i] * nums[length - i];
        }

        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }
}
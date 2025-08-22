class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = max;
        for (int i = 1; i < nums.length; i++) { //순회하면서 max,min을 관리하며 max를 갱신. subarray여야함(consecutive)
            
            int temp = max;
            max = Math.max(Math.max(nums[i], max * nums[i]),
                            min * nums[i]);
            min = Math.min(Math.min(nums[i], min * nums[i]),
                            temp * nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
/**
easy as freak
선택지가 2개. 음수냐 양수냐
그러면 두개 관리하면 됨ㅋㅋ 어디선가 본 논리지
 */
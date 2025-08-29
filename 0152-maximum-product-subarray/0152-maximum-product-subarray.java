class Solution {
    public int maxProduct(int[] nums) {
        
        int ans = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmpMax = max;
            max = Math.max(Math.max(max * nums[i], nums[i]), min * nums[i]);
            min = Math.min(Math.min(tmpMax * nums[i], nums[i]), min * nums[i]);
            ans = Math.max(ans, max);
            //System.out.printf("at index:%d, max=%d, min=%d, ans=%d", i, max, min, ans);
        }
        return ans;
    }
}
/**
음수면 문제가 생긴다
각 인덱스에 해당하는 숫자가 양수면 최댓값이랑 곱해서 업데이트
음수도 따로 관리를 해둬야함. 

 */
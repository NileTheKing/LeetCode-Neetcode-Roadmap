class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] pair = new int[nums.length][2];//2는 값과 인덱스
        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
        Arrays.sort(pair, (o1, o2) -> o1[0] - o2[0]);//값정렬
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int sum = pair[l][0] + pair[r][0];
            if (sum > target) {
                r--;
            }else if (sum < target) {
                l++;
            }else {
                return new int[] {pair[l][1], pair[r][1]};
            }
        }
        return new int[0];
    }
}
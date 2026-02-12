class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i -1]) continue;
            int l = i;
            int m = i + 1;
            int r = nums.length - 1;
            int target = -nums[l];
            while (m < r) {
                if (m > l + 1 && nums[m] == nums[m - 1]) {
                    m++;
                    continue;
                }
                int sum_mr = nums[m] + nums[r];
                if (sum_mr == target) {
                    // System.out.printf("sum_mr: %d, target=%d, l,m,r = %d %d %d\n", sum_mr, target, l,m,r);
                    ans.add(Arrays.asList(nums[l],nums[m],nums[r]));

                }else if (sum_mr < target) {
                    m++;
                }else {
                    r--;
                }
            }
        }
        return ans;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //3 * 10^3.  o(n^3) 불가능 o(n^2)가능. 
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i;
            if (l > 0 && nums[l] == nums[l - 1]) continue;
            System.out.printf("=== %d ===\n", l);
            int m = i + 1;
            int r = nums.length - 1;
            while (m < r) {
                if (m > i + 1 && nums[m] == nums[m - 1]) {
                    m++;
                    continue;
                }
                // System.out.printf("     ===%d %d %d===\n", l, m, r);
                int target = -nums[l]; //nums[m] + nums[r]했을떄 -nums[l]나와야한다
                int sum = nums[m] + nums[r];// [m] + [r]
                if (sum > target) {
                    r--;
                }else if (sum < target) {
                    m++;
                }else {
                    // System.out.printf("%d %d %d\n", l, m, r);
                    ans.add(Arrays.asList(nums[l], nums[m], nums[r]));
                    m++;
                }
            }
        } 
        return ans;

    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for (int l =  0; l < nums.length; l++) {
            //if (l > 0 && nums[l] == nums[l-1]) continue;
            int m = l + 1;
            int r = nums.length - 1;
            int target = -nums[l];// sum that m and r should make up
            while (m <= nums.length -1 && m < r) {
                int sum = nums[m] + nums[r];
                //System.out.printf("nums[%d] + nums[%d] = %d\n", m,r,sum);
                if (sum > target) {
                    r--;
                }else if(sum < target) {
                    m++;
                }else {
                    //System.out.printf("l,m,r: %d %d %d\n", l,m,r);
                    ans.add(Arrays.asList(nums[l],nums[m], nums[r]));
                    m++;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
/**
l + m + r = 0
 */
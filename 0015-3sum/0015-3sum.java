class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int l =  0; l < nums.length; l++) {
            if (l > 0 && nums[l] == nums[l-1]) continue;
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
                }else { //일단 합이 되면 추가는 해야되고 m도 올려줘야하고..
                    //System.out.printf("l,m,r: %d %d %d\n", l,m,r);
                    if (m > l + 1 && nums[m] == nums[m - 1]) {
                        //System.out.printf("passing. l = %d, m = %d, r = %d\n", l,m,r);
                        m++; continue;
                    }
                    else {ans.add(Arrays.asList(nums[l],nums[m], nums[r]));
                    m++;
                    }
                }
            }
        }
        return ans;
    }
}
/**
l + m + r = 0
 */
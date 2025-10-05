class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int l = 0; l < nums.length - 2; l++) {
            if (l > 0 && nums[l] == nums[l -1]) continue;
            //각 l에 대해 투포인터 진행
            int m = l + 1;
            int r  = nums.length - 1;
            if (m >= nums.length - 1 || r >= nums.length) break;
            // nums[i] + nums[m]+ nums[r] == 0 -> 
            int target_mr = -nums[l];
            while (m < r) {
                if (m > l + 1 && nums[m] == nums[m-1]) {m++; continue;}
                if (r < nums.length - 1 && nums[r] == nums[r + 1]) {r--; continue;}
                int num_m = nums[m];
                int num_r = nums[r];
                // System.out.printf("l,m,r: %d %d %d\n", l, m, r);
                // System.out.printf("nums[l] == %d, target m+r= %d\n", nums[l], target_mr);
                // System.out.printf("current mr sum = %d\n", num_m + num_r);
                
                //일치
                if (num_m + num_r == target_mr) {
                        ans.add(Arrays.asList(nums[l],num_m,num_r));
                        m++;
                }
                //합한게 너무 작음
                else if (num_m + num_r < target_mr) m++;
                //합한게 더 큼
                else r--;
            }
        }
        return ans;
    }
}
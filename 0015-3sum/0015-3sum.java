class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();


        //i,j,k triplet. Get i fixed to iterate over the array. -> so no skipping over missing cases
        for (int i = 0; i < nums.length - 2; i++) {//
            int left = nums[i];
            if (left > 0) break;
            //if (nums[i] = nums[i + 1])

            int j  = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int mid = nums[j];
                int right = nums[k];

                if (left + mid + right == 0) {
                    
                    res.add(Arrays.asList(left, mid, right));

                    while (j < k && nums[j] == nums[j+1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    
                    j++;
                    k--;
                }else if (left + mid + right < 0) {
                    j++;
                }
                else {
                    k--;
                }  
            }
        }

        return res;
    }
}
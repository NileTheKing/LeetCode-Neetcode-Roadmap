class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();


        //i,j,k triplet. Get i fixed to iterate over the array. -> so no skipping over missing cases
        for (int i = 0; i < nums.length - 2; i++) {//
            int left = nums[i];
            if (left > 0) break;

            int j  = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int mid = nums[j];
                int right = nums[k];

                if (left + mid + right == 0) {
                    List<Integer> added = new ArrayList<>();
                    added.add(left);
                    added.add(mid);
                    added.add(right);

                    set.add(added);
                    
                    j++;
                }else if (left + mid + right < 0) {
                    j++;
                }
                else {
                    k--;
                }  
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> s : set) {
            res.add(s);
        }

        return res;
    }
}
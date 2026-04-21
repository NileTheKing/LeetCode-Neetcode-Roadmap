class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        //Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }
    public void backtrack(int[] nums, int idx, List<Integer> current) {

        ans.add(new ArrayList<>(current));
        for (int i = idx; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);

        return res;
    }
    public void dfs(int[] nums, List<Integer> current, int idx) {
        
        res.add(new ArrayList<>(current));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            dfs(nums, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
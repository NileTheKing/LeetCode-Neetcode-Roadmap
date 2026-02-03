class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(new ArrayList<>(), 0, nums);
        return ans;
    }
    public void dfs(List<Integer> current, int idx, int[] nums) {
        ans.add(new ArrayList<>(current));
        for (int i = idx; i < nums.length; i++) {
            if (i  > idx && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            dfs(current, i + 1, nums);
            current.remove(current.size() - 1);
        }
    }
}
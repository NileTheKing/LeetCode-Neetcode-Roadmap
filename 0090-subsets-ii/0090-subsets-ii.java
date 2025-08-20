class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());

        return ans;
    }
    public void dfs(int[] nums, int idx, List<Integer> current) {
        ans.add(new ArrayList<>(current));
        if(idx == nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            dfs(nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }

}
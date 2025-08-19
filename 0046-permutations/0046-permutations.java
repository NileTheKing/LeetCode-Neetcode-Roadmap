class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new boolean[nums.length], new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums, boolean[] visited, List<Integer> current) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList(current));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(nums[i]);
                dfs(nums, visited, current);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}
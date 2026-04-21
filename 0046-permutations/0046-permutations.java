class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        backtrack(nums, 0, new boolean[nums.length], new ArrayList<>());
        return ans;
    }
    public void backtrack(int[] nums, int depth, boolean[] visited, List<Integer> current) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(current));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            current.add(nums[i]);
            backtrack(nums, depth + 1, visited, current);
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
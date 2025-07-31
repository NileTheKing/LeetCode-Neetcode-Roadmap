class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
           
            dfs(nums, new ArrayList<>(), new boolean[nums.length], 0);
           return res;
    }
    public void dfs(int[] nums, List<Integer> current, boolean[] visited, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            current.add(nums[i]);
            dfs(nums, current, visited, depth + 1);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
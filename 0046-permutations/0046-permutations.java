class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]); //TODO
        return ans;
    }
    public void backtrack(int[] nums, List<Integer> current, boolean[] visited) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            current.add(nums[i]);
            backtrack(nums, current, visited);
            visited[i] = false;
            current.remove(current.size() - 1);
            // backtrack(nums, current, visited);
        }
    }
}
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, new ArrayList<>(), 0, target, 0);

        return ans;
    }
    public void dfs(int[] candidates, List<Integer> current, int currentSum, int target, int idx) {
        if (currentSum == target) ans.add(new ArrayList<>(current));
        if (currentSum > target) return;

        for (int i = idx; i < candidates.length; i++) {
            current.add(candidates[i]);
            dfs(candidates, current, currentSum + candidates[i], target, i);
            current.remove(current.size() - 1);
        }
    }
}
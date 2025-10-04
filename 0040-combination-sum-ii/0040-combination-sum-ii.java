class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, 0, new ArrayList<>());

        return ans;
    }
    public void backtrack(int[] candidates, int current, int target, int idx, List<Integer> path) {
        if (current == target) {
            ans.add(new ArrayList<>(path));
        }
        if (current > target) return;

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            current += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, current, target, i + 1, path);
            current -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
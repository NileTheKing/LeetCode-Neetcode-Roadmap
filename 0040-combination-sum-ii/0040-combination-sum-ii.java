class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();

        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return ans;
    }
    public void dfs(int[] candidates, int target, int idx, List<Integer> current, int cSum) {

        if (cSum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }
        if (idx == candidates.length) return;

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i-1]) continue;
            if (cSum + candidates[i] > target) return;

            current.add(candidates[i]);
            dfs(candidates, target, i + 1, current, cSum + candidates[i]);
            current.remove(current.size() -1);
        }
        return;
    }
}
/**
1 1 2 5 6 7 10

 */
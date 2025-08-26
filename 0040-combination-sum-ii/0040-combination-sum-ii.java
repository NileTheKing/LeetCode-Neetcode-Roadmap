class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, 0, new ArrayList<>());//todo
        return ans;
    }
    public void dfs(int[] candidates, int idx, int target, int currentSum, List<Integer> path) {
        if (currentSum == target) {
            ans.add(new ArrayList<>(path));
        }

        for (int i = idx; i < candidates.length; i++) {
            if (currentSum + candidates[i] > target) return; //가망없음. 정렬되어있는 거라 뒤에 거도 다 안될거임
            if (i > idx && candidates[i] == candidates[i -1]) continue; //뒤에 경우의 수 보기. 이미 이 경우의 수는 다 봤던 거임.
            path.add(candidates[i]);
            dfs(candidates, i + 1, target, currentSum + candidates[i], path);
            path.remove(path.size() -1);
        }
    }
}
/**
sort
dfs backtrack
duplicate check
 */
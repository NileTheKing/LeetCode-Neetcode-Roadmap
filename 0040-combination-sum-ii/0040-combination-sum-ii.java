class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        dfs(candidates, 0, target , 0, new ArrayList<>());

        // //중복제거
        // Set<List<Integer>> set = new HashSet<>();
        // for(List<Integer> list : ans) {
        //     set.add(list);
        // }
        return ans.stream().distinct().collect(Collectors.toList());
    }
    public void dfs(int[] candidates, int total, int target, int idx, List<Integer> current) {
        if (total == target) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] + total > target) {
                return;
            }
            if (i > idx &&candidates[i] == candidates[i -1]) continue;
            current.add(candidates[i]);
            dfs(candidates, total + candidates[i], target, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
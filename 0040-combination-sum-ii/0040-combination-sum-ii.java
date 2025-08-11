class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    //int length;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        //length = candidates.length;
        backtrack(candidates, target, 0, 0, new ArrayList<>());

        return ans;
    }
    public void backtrack(int[] candidates, int target, int total, int idx, List<Integer> current) {
 
        if (total == target) {
            ans.add(new ArrayList<>(current)) ;
            return;
        }
        //if (idx == length) return;

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i -1]) continue;
            if (total + candidates[i] > target) return; //정렬 되어있으니까 candiate이 너무 크다면 뒤에 for문은 볼필요도 없다
            current.add(candidates[i]);
            backtrack(candidates, target, total + candidates[i], i + 1, current);
            current.remove(current.size() - 1);
        }
        return;
    }
}
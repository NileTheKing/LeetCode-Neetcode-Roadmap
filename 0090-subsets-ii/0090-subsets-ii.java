class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums, int index, List<Integer> current) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }
        //System.out.printf("iterating index %d\n", index);
        ans.add(new ArrayList<>(current));
        
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]);
            dfs(nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
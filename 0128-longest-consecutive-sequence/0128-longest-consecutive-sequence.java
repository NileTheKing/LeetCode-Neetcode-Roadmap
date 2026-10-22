class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int max = 0;
        for (int n : set) {
            if (set.contains(n - 1)) continue;
            int next = n + 1;
            int streak = 1;
            while (set.contains(next)) {
                streak++;
                next++;
            }
            max = Math.max(streak, max);
        }
        return max;
    }
}
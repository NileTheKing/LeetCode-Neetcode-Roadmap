class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak =  1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                    max = Math.max(max, currentStreak);
                }
            }
        }

        return max;
    }
}
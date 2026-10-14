    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) return 0;
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                set.add(n);
            }

            int max = 1;
            for (int n  : set) {
                if (set.contains(n - 1)) continue;
                int currentStreak = 1;
                int currentNumber = n;
                while (set.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentStreak++;
                }
                max = Math.max(max, currentStreak);
            }
            return max;
        }
    }
    /**
    정렬안됨
    1go
    hash써야할듯

    만약 다넣어
    그러고 확인

    */
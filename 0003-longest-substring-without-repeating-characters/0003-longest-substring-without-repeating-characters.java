class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int l = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < len; i++) {
            int r = i;
            char c = s.charAt(r);
            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
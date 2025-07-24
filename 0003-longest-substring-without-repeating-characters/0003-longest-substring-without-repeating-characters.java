class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            //System.out.println("checking right: " + right);
            //if current substring(from left to right) has duplicate
            while (set.contains(c)) {
                //System.out.println("current " + c + " is contained");
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
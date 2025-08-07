class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;

        HashSet<Character> set = new HashSet<>();

        while (r < s.length()) {
            char c = s.charAt(r); //새로 확인 중인 문자
    
            
            while (set.contains(c) && l < r) {
                //ystem.out.println("set contains " + c);
                set.remove(s.charAt(l));
                l++;
            }

            set.add(c);
            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}
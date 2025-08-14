class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String ans = new String();

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l  +1 > max) {
                    max = r - l + 1;
                    ans = s.substring(l,r + 1);
                }
                l--;
                r++;
            }
            

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l  +1 > max) {
                    max = r - l + 1;
                    ans = s.substring(l,r + 1);
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}
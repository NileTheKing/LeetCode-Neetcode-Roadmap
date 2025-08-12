class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                cnt++;
                l--;
                r++;
            }
            l = i;
            r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                cnt++;
                l--;
                r++;
            }
        }
        return cnt;
    }
}
class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String ans = new String();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int l = i;
                int r = j;
                while (l < r && s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                }
                if (l >= r && j - i + 1 > max) { //모두 통과
                    //System.out.println("l, r:" + l + ","+ r);
                    max = j - i + 1;
                    ans = s.substring(i,j+1);
                }
            }
        }     
        return ans;
        
    }
}
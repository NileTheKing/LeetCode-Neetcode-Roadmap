class Solution {
    public int numDecodings(String s) {
        int size = s.length();
        
        int[] dp = new int[size+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= size; i++) {
            if (s.charAt(i-1) != '0')
                dp[i] = dp[i-1];
            if (isValid(s.substring(i-2,i))) {
                dp[i] += dp[i-2];
            }
        }
        return dp[size];
    }
    public boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        
        int val = Integer.parseInt(s);
        if (val <= 0 || val > 26) return false;

        return true;
    }

}
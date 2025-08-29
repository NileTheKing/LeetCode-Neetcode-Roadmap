class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int length = word.length(); // for index calc
                if (i - length >= 0 && dp[i-length] && s.substring(i-length,i).equals(word)) {
                    dp[i] = true;
                    //System.out.printf("at dp[%d]: substring %s + %s makes up %s\n", i, s.substring(0,i-length), s.substring(i-length, i), s.substring(0, i));
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
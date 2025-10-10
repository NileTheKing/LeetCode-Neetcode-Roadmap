class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1]; //dp[i]는 s의 i인덱스 이전까지 된다 이뜻
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                int length = w.length();
                if (i - length >= 0 && dp[i-length] && s.substring(i-length, i).equals(w)) //i-length-1인덱스까지 되는거면 현재 dp[i]즉 s에서 i-1인덱스까지 되냐보는거
                    dp[i] = true;
            }
        }
        return dp[s.length()];
    }
}
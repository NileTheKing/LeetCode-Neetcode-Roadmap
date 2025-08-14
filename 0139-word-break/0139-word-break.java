class Solution {
    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length() + 1]; //if dp[3] true -> 3글자는 ok.
        //dp[0] = 1; //1 good 0not yet -1no
        return dfs(s, wordDict, 0);
    }   
    public boolean dfs(String s, List<String> wordDict,int cnt) {//cnt for dp
        if(cnt == s.length()) return true;
        if (dp[cnt] == -1) return false; //cnt까지 완성을 못한다.
        if (dp[cnt] == 1) return true;

        for (String word : wordDict) {
            if (s.startsWith(word, cnt)) {
                if(dfs(s, wordDict, cnt  + word.length())) {
                    dp[cnt] = 1;
                    return true;
                }
            }
            
        }
        dp[cnt] = -1;
        return false;
    }
}
/**
wordDict에 있는 옵션들로 조합해서 s를 완벽하게 만들어야 한다.
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) { //글자단위로 변경. i글자까지 완성 가능하냐 이거임.
            //날먹가능확인.
            for (String str : wordDict) {
                        if (s.substring(0,i).equals(str)) dp[i] = true;
            }
            if (dp[i]) continue;
            for (int j = 1; j <= i; j++) { //이전까지의 dp를 모두 확인하겠따
                if (dp[i-j]) {
                    for (String str : wordDict) {
                        if(s.substring(i-j, i).equals(str)) dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
/**
if any combination of wordDict can make up s -> true

 */
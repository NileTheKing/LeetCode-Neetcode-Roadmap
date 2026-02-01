class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1]; //dp[3] -> 3글자까지 가능
        dp[0] = true; //0은 된다고 하고 시작
        for (int i = 1; i <= len; i++) {
            for (String str : wordDict) {
                int sLen = str.length();
                if (i - sLen < 0) continue; //bound 예외 처리
                if (dp[i - sLen] && s.substring(i - sLen, i).equals(str)){ // i글자에서 가능한거니까 인덱스는 i-1에서 잘리면됨.substring기본 작동이 그ㅓ니까 맞음
                    System.out.printf("dp[%d] = true\n", i);
                    dp[i] = true;
                    }
            }
        }
        return dp[len];
    }
}
/**
wordDict에 있는 것들로 s를 만들면 됨.
이거는 dp. 기존 재활용하는 게 있으므로.memoization
 */
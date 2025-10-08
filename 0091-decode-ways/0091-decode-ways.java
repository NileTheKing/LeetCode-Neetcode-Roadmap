class Solution {
    public int numDecodings(String s) {
        
        if (s.charAt(0) == '0') return 0;
        //dp[1]인데 10 20이면 dp[1]은 1임 나머지는 2
        if (s.length() == 1) return 1;
        int two = Integer.parseInt(s.substring(0,2));
        int[] dp =  new int[s.length()];
        if (s.charAt(1) == '0') {
            if (two >= 10 && two <= 26) {
                dp[0] = 1;
                dp[1] = 1;
            }else {
                dp[0] = 1;
                dp[1] = 0;
            }
        }else {
            if (two >= 10 && two <= 26) {
                dp[0] = 1;
                dp[1] = 2;
            }else {
                dp[0] = 1;
                dp[1] = 1;
            }
        }

        for (int i = 2; i < s.length(); i++) {
            //한글자만
            if (s.charAt(i) != '0') {
                //System.out.printf("one digit: %c\n", s.charAt(i));
                dp[i] = dp[i-1];
            }
            //두글자
            int twodigits = Integer.parseInt(s.substring(i-1, i+1));
            if (twodigits >= 10 && twodigits <= 26) {
                
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }
}
/**
dp[i] 는 해당인덱스까지 할 수 있는 방법
dp[s.length() - 1] 인덱스가 정답


226

 */
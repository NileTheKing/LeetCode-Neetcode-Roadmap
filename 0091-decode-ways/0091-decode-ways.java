class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()]; //dp[i] means the number of ways possible at index i
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        dp[0] = 1;
        //dp[1]
        if (s.charAt(1) == '0') {
            if (s.charAt(0) == '1' || s.charAt(0) == '2') {
                dp[1] = 1;
            }else {
                dp[1] = 0;
                //System.out.printf("check!");
            }
        }else {
            if (s.charAt(0) == '1') {
                dp[1] = 2;
            }else if (s.charAt(0) == '2'  && s.charAt(1) - '0' >= 1 && s.charAt(1) - '0' <= 6) {
                dp[1] = 2;
            }else {
                dp[1] = 1;
            }
        }

        for (int i = 2; i < s.length(); i++) {
            //한글자로 볼 수 있는지
            //System.out.printf("check\n");
            char c = s.charAt(i);
            if (c != '0') dp[i] = dp[i-1];
            //앞에거랑해서 2글자로 끊어지는지
            char prev = s.charAt(i - 1);
            if (prev == '1') {
                dp[i] += dp[i-2];
            }else if(prev == '2' && c - '0' >= 0 && c - '0' <= 6) {
                dp[i] += dp[i - 2];
            }else {
                //System.out.printf("At %d, dp[%d] = %d\n", i, i, dp[i]);
                continue;
            }
        }
        // System.out.printf("dp[0] == %d\n", dp[0]);
        // System.out.printf("dp[1] == %d\n", dp[1]);
        return dp[s.length() - 1];
        
        
    }
}
/**
2101

2
2/1
21
2/10

2/10/1



 */
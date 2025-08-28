class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0)=='0') return 0;
        int dp[] = new int[s.length() + 1]; //dp[i] means until length i read from the string, how many ways can it be decoded
        dp[0] = 1;
        dp[1] = s.charAt(0) == 0 ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            //바로앞 경우의 수에서 그냥 하나 더 붙이는 거. 경우의수는 그대로.
            //플러스 앞앞까지 경우의 수에서 두개 붙이는거.
            char current = s.charAt(i-1);
            if (current != '0') {
                dp[i] = dp[i-1];
            }
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            System.out.printf("twoDigits nun : %d, ", twoDigits);
            if (twoDigits >= 10 && twoDigits <= 26) dp[i] = dp[i] + dp[i-2];
            System.out.printf("dp[%d] = %d\n", i, dp[i]);
        }
        return dp[s.length()];
    }
}
/**
얘도 각 자리에서 선택지가 두개임.. 문제를 나눌 수 있고 이걸 동시에 관리 가눙
 */
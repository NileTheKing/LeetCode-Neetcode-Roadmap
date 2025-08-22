class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1]; //sub(0,i) 가능여부임. 
        //length-1인덱스의 값은 dp[length] 에 담겨있음.
        dp[0] = true;

        for (int i = 1; i <= length; i++) {
            for (String w : wordDict) { //i가 4일떄 leet가능ㅇ.
                if (i - w.length() >= 0 && dp[i-w.length()] && s.substring(i - w.length(), i).equals(w)) {
                    dp[i] = true; //그전께 됐다면 가능
                    break;
                    //System.out.println("sub(" + (i-w.length()) + ", " + i +") updated dp["+i+"]");
                    //System.out.println("current word:" + w);
                    //System.out.println("trying to make: " + s.substring(i-w.length(), i));
    
                }
            }
        }

        return dp[length];
    }
}
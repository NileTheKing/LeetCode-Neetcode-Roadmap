class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length][nums.length]; //memo[0][3] -> 0부터3까지 최대길이
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(nums, 0, -1, memo);
        
    }
    public int dfs(int[] nums, int i, int j,int[][] memo) {
        
        if (i == nums.length) {
            return 0;
        }
        if (memo[i][j+1] != -1) {
            return memo[i][j+1];
        }

        int in = 0;
        if (j == -1 || nums[i] > nums[j]) {
            in = 1 +dfs(nums, i+1, i, memo);
        }

        int ex = dfs(nums, i + 1, j, memo);

        memo[i][j+1] = Math.max(in, ex);
        return memo[i][j+1];
       

    }
}
/**r
bottom up

dp[0]= [1,10]: 10 숫자랑 가장 큰수/작은수 관리
dp[1]= 


brute force하면
각 index마다 다 해보는?
아니면 각 인덱스마다 left right 가고
left는 현재 범위중에 최소보다 작으면 가는거임 : < 이건 안됨 2 5 3 7에서 2 3 7 가능임
일단 움직이고 카운트엔 포함안함? 이상한데
이거는 포인터로는 안되겠따

10으로 시작. 10보다 더 큰거 101. 얘보다 더큰거 없음 ->2
9로 시작. 9부터 더 큰거 101. 101보다 더큰거 ㅇ벗음 ->2
2로 시작. 2보다 더 큰거 5. 5보다 더 큰거 7. 7보다 더 큰거 101. 2 5 7 101
        2보다 더 큰거 


뒤에서 가보자
dp가 되는 건 확실함.
재귀도 되고 문제가 작아지니까
아마 바텀업으로 tab도 될듯



 */
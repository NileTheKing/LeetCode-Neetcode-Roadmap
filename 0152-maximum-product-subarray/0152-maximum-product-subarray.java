class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];

        for (int i = 0; i < n; i++) {
            int current = 1;
            for (int j = i; j < n; j++) {
                current = current * nums[j];
                res = Math.max(current, res);
            }
        }
        return res;
    }
}
/**
subarray  -> two pointer
    하지만 넣냐 안넣냐의 문제가 아님. 정도의 차이가 있기 떄문.

그렇다면 완전 탐색을 하냐?배열은 10000개. n2이면 1,000,000,000
O(n)으로 풀어야함. or nlogn

 */
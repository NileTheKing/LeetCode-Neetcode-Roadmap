class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) break;
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];


            if (slow == slow2) return slow;
        }
    }
}
/**
constant extra space -> no hashmap
without modifying -> no sorting

1-n이면 n개의 숫자가 있어야함(오름차순)
n+1개이려면 2개가 중복이어야함.
만약 3개가 중복에다가 n+1개라면 중복3개이니까 하나가 비어야함.
 */
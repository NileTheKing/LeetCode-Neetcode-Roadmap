class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //값, 인덱스
    
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i]; //더해야하는값 nums[i]제어ㅚ
            if (map.containsKey(a) && map.get(a) != i) return new int[] {i, map.get(a)};
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
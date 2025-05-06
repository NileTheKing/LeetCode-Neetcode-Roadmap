class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            //System.out.println("left = " + numbers[left] + "right = " + numbers[right]);
            if (numbers[left] + numbers[right] == target) {
                return new int[] {left + 1, right + 1};
            }

            if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }
}
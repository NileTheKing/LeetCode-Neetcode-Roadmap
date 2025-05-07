class Solution {
    public int trap(int[] height) {
        /**
        현재 칸의 물의 양은 왼쪽오른쪽 중에 작은 놈에 대해 결정됨
        왼쪽이 작다면 왼쪽중에 가장 작은값
        vice versa


         */
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {


            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                water += (leftMax - height[left]);
                left++;
            }
            else {
                rightMax = Math.max(height[right], rightMax);
                water += (rightMax- height[right]);
                right--;
            }
        }

        return water;
    }
}
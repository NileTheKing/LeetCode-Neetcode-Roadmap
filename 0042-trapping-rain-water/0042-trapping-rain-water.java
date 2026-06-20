class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int l = 0;
        int r = len - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        int sum = 0;
        while (l <= r) {
            if (leftMax < rightMax) {
                sum += Math.max(0, leftMax - height[l]);
                leftMax = Math.max(leftMax, height[l]);
                l++;
            }else {
                sum += Math.max(0, rightMax - height[r]);
                rightMax = Math.max(rightMax, height[r]);
                r--;
            }
        }
        return sum;
        
    }
}
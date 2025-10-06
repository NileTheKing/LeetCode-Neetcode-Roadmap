class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int currentLeftMax = 0;
        leftMax[0] = 0;
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(currentLeftMax, height[i-1]);
            currentLeftMax = Math.max(currentLeftMax, height[i-1]);
            //System.out.printf("leftMax[%d] = %d, currentLeftMax = %d\n", i, leftMax[i], currentLeftMax);
        }
        int currentRightMax = 0;
        rightMax[height.length - 1] = 0;
        for (int i = height.length - 1 - 1; i >= 0; i--) {
            rightMax[i] = Math.max(currentRightMax, height[i+1]);
            currentRightMax = Math.max(currentRightMax, height[i+1]);
            //System.out.printf("rightMax[%d] = %d, currentRightMax = %d\n", i, rightMax[i], currentRightMax);
        }

        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            int diff = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (diff > 0) sum += diff;
        }
        return sum;
    }
}
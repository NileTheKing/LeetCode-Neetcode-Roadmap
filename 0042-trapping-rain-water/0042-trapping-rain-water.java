class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = 0;
        leftMax[1] = height[0];
        for (int i = 2; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            //System.out.printf("leftMax[%d] == %d\n", i, leftMax[i]);
        }

        rightMax[height.length - 1] = 0;
        rightMax[height.length - 1 - 1] = height[height.length - 1];
        for (int i = 2; i < height.length; i++) {
            //leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            rightMax[height.length - 1 - i] = Math.max(rightMax[height.length - 1 - i + 1], height[height.length - 1 - i + 1]);
            //System.out.printf("rightMax[%d] == %d\n", height.length -1 - i, rightMax[height.length - 1 - i]);
        }
        // for (int i = 0; i < height.length; i++) {
        //     System.out.printf("current cell %d's leftMax: %d, rightMax: %d\n", i, leftMax[i], rightMax[i]);
        // }
        int ans = 0;
        for (int i = 1; i < height.length; i++) {
            int diff = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (diff > 0){
                ans += diff;
                //System.out.printf("current space %d holds %d water\n",i, diff);
            }

        }
        return ans;
    }
}
class Solution {
    public int trap(int[] height) {
        
        int len = height.length;
        int[] maxl = new int[len];
        int[] maxr = new int[len];
        
        maxl[0] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            maxl[i] = Math.max(maxl[i - 1], height[i - 1]);
        }
        maxr[len - 1] = Integer.MIN_VALUE;
        for (int i = len - 1 - 1; i > 0; i--) {
            maxr[i] = Math.max(maxr[i + 1], height[i + 1]);
        }
        
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            int min_from_maxlr = Math.min(maxl[i], maxr[i]);
            if (height[i] >= min_from_maxlr) continue; //담을 물이 없음
            int diff = min_from_maxlr - height[i];
            sum += diff;
        }
        return sum;
    }
}
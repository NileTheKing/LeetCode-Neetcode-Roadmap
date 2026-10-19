class Solution {
    public int minimumEffort(int[][] tasks) {
    
        Arrays.sort(tasks, (o1, o2) -> Integer.compare(o1[1] - o1[0], o2[1] - o2[0]));//오름차순정렬
        
        
        int ans = 0;
        for (int[] t: tasks) {
            ans = Math.max(ans + t[0], t[1]);
        }
        return ans;
        
    }
}
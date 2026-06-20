class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> ans = new ArrayList<>();
        int ptr = 0; //할 얘
        while (ptr < intervals.length) {
            int tmp = ptr + 1;
            int start = intervals[ptr][0];
            int end = intervals[ptr][1];
            while (tmp < intervals.length && intervals[tmp][0] <= end) {
                end = Math.max(end, intervals[tmp][1]);
                tmp++;
            }
            ans.add(new int[] {start, end});
            ptr = tmp;
        }
        return ans.toArray(new int[0][]);
    }
}
/**
n^2
 */
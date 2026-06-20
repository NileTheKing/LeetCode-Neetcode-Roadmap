class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> ans = new ArrayList<>();
        boolean[] processed = new boolean[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            if (processed[i]) continue;
            int start = intervals[i][0];
            int end = intervals[i][1];
            for (int j = i + 1; j < intervals.length; j++) {
                if (!processed[j] && intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                    processed[j] = true;
                }
            }
            processed[i] = true;
            ans.add(new int[] {start, end});
        }

        return ans.toArray(new int[0][]);
    }
}
/**
정렬후 계속 될떄까지 확인해봐야하는데.. 그냥 o(n^2)
 */
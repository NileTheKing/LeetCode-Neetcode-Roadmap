class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> graph = new ArrayList<>(); //점 인덱스번호,거리
        for (int i = 0; i < points.length; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < points.length; i++) {
            int[] v1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] v2 = points[j];
                int xdiff = Math.abs(v1[0] - v2[0]);
                int ydiff = Math.abs(v1[1] - v2[1]);
                int distance = xdiff+ydiff;
                graph.get(i).add(new int[] {j, distance});
                graph.get(j).add(new int[] {i, distance});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[] {0, 0});//0번인덱스점
        boolean[] visited = new boolean[points.length];
        int limit = 0;
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            if (visited[polled[0]]) continue;
            limit++;
            visited[polled[0]] = true;
            ans += polled[1];
            for (int[] nei : graph.get(polled[0])) {
                pq.offer(new int[] {nei[0], nei[1]});
            }
        }
        return ans;
    }
}
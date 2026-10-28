class Solution {
    public int minTime(int n, int[][] edges) {
        
        List<List<int[]>> graph = new ArrayList<>(); //[도착노드,시간1,시간2]
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            int v1 = e[0];
            int v2 = e[1];
            int start = e[2];
            int end = e[3];

            graph.get(v1).add(new int[] {v2, start, end});
        }
        
        //[노드,도착시각]
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        pq.offer(new int[] {0,0});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;//도달가능한 최소시간

        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            if (polled[1] > dist[polled[0]]) continue;
            // System.out.printf("at %d. currentCost:%d\n", polled[0], polled[1]);
            for (int[] nei : graph.get(polled[0])) {
                int nextNode = nei[0];
                int start = nei[1];
                int end = nei[2];

                //vistied
                if (dist[nextNode] <= polled[1] + 1) continue;
                if (polled[1] > end) continue;
                
                int nextVal = polled[1] < start ? start + 1 : polled[1] + 1;
                if (nextVal >= dist[nextNode]) continue;
                //pqoffer
                dist[nextNode] = nextVal;
                pq.offer(new int[] {nextNode, nextVal});
            }
        }
        return dist[n-1] == Integer.MAX_VALUE ? -1 : dist[n-1];
        
    }
}
/**
시간 = 거리. 무가중그래프. 
지금 고려안한거는 대기하는것인데..
 */
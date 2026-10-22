class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        //서버pq넣기. 시간과 weight을 둘다 가질
        //[weight, index]
        PriorityQueue<int[]> idle = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        //초기엔 다 노는중
        for (int i = 0; i < servers.length; i++) {
            idle.offer(new int[] {servers[i], i});
        }
        //[시각, 인덱스]
        PriorityQueue<int[]> inUse = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        //tasks 시간순으로 돌기
        int idx = 0;
        int[] ans = new int[tasks.length];
        for (int t = 0; t < tasks.length; t++) { //시간임
            // System.out.printf("====%d초=====\n", t);
            //해당초에 inUse였던 서버가 시각되었으면 idle로옮기기
            while (!inUse.isEmpty() && inUse.peek()[0] == t) {
                int[] polled = inUse.poll();
                int serverIdx = polled[1];
                int weight = servers[serverIdx];
                // System.out.printf("%d 서버 일 끝, weight: %d\n", serverIdx, weight);
                idle.offer(new int[] {weight, serverIdx});
            }
            
            //idle이 남았으면? order of insertions에 맞게 다 넣음
            while (idx <= t && !idle.isEmpty()) {
                //idle서버 골라서, inUse에넣기. ans기록하고 idx늘리고
                int[] polled = idle.poll();
                int serverIdx = polled[1];
                int serverWeight = polled[0];

                int jobTime = tasks[idx];
                ans[idx++] = serverIdx;
                
                inUse.offer(new int[] {t + jobTime, serverIdx});
            }
            //할거없으면..기다림.
        }
        int t = tasks.length;
        while (idx < tasks.length) {
            if (idle.isEmpty()) t = inUse.peek()[0];
            while (!inUse.isEmpty() && inUse.peek()[0] == t) {
                int[] polled = inUse.poll();
                int serverIdx = polled[1];
                int weight = servers[serverIdx];
                // System.out.printf("%d 서버 일 끝, weight: %d\n", serverIdx, weight);
                idle.offer(new int[] {weight, serverIdx});
            }
            while (idx < tasks.length && !idle.isEmpty()) {
                //idle서버 골라서, inUse에넣기. ans기록하고 idx늘리고
                int[] polled = idle.poll();
                int serverIdx = polled[1];
                int serverWeight = polled[0];

                int jobTime = tasks[idx];
                ans[idx++] = serverIdx;
                
                inUse.offer(new int[] {t + jobTime, serverIdx});
            }
        }
        
        
        return ans;
    }
}
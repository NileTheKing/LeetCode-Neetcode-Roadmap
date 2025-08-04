class Solution {
    public int orangesRotting(int[][] grid) {
        //bfs
        //남은 오렌지// 매번 세어야 하나?
        //처음에 갯수 세고 썩을 때 마다 1감소
        //매 while당 확인
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    //cnt++;
                    q.offer(new int[] {i, j});
                }
                else if (grid[i][j] == 1) cnt++;
            }
        }
        if (cnt == 0) return 0;
        int time = 0;
        while (!q.isEmpty()) {
            if (cnt == 0) return time;
            time++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] polled = q.poll();
                for (int[] d : directions) {
                    int nr = d[0] + polled[0];
                    int nc = d[1] + polled[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue; //바운드
                    //이미 썩거나 빈거는 안함
                    if (grid[nr][nc] == 1) {
                        //썩게 하고 큐에 넣음
                        grid[nr][nc] = 2;
                        q.offer(new int[] {nr, nc});
                        cnt--;
                    }
                }
            }
        }
        return -1;
    }
}
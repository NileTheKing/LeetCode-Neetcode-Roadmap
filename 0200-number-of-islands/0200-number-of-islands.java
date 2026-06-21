class Solution {
    int[][] directions = {{-1,0}, {1,0}, {0, 1}, {0, -1}};
    int m, n;
    public int numIslands(char[][] grid) {
        int cnt = 0;
        //bfs/dfs하면서 처리..guard clause하고(방문) 그게아닌거만 카운트
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1') continue;
                //bfs수행.인접한거 2로마킹
                bfs(i, j, grid);
                cnt++;
            }
        }
        return cnt;
    }
    public void bfs(int r, int c, char[][] grid) {
        // System.out.printf("===start of bfs..(%d, %d)===\n", r,c);
        Queue<int[]> q = new LinkedList<>();
        //visited필요없음
        q.offer(new int[] {r, c});
        grid[r][c] = '2';
        while (!q.isEmpty()) {
            int[] polled = q.poll();
            // System.out.printf("visited (%d, %d)\n", polled[0], polled[1]);
            for (int[] d : directions) {
                int nr = polled[0] + d[0];
                int nc = polled[1] + d[1];
                
                //bound
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                //visit확인
                if (grid[nr][nc] == '2') continue;
                //1인지확인
                if (grid[nr][nc] != '1') continue;
                q.offer(new int[] {nr, nc});
                grid[nr][nc] = '2'; //방문처리
            }
        }
        return;
    }
}
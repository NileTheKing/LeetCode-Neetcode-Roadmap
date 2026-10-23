class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1}, {0,-1}};
    public int shortestPathAllKeys(String[] grid) {
        //board 배열로 바꾸기
        int m = grid.length;
        int n = grid[0].length();
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            board[i] = grid[i].toCharArray();
        }

        int goalBit = 0;
        int currentBit = 0;//어디까지 모았나. 사용해도 유지가능
        int startR = 0, startC = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c >= 'a' && c <= 'z') goalBit |= (1 << (c - 'a'));
                else if (c == '@') {startR = i; startC = j;}
            }
        }
        //이제 bfs순회. 상태관리bfs. 키는 최대 6개존재. 111111까지가능.. 그러려면 1000000을만들어야.
        boolean[][][] visited = new boolean[m][n][1 << 6];
        //{r,c,keyGot,steps}
        Queue<int[]> q = new LinkedList<>(); //{r, c, status, step}
        q.offer(new int[] {startR, startC, 0, 0});
        visited[startR][startC][0] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] polled = q.poll();
                // System.out.printf("(%d,%d),status:%d, step:%d\n", polled[0],polled[1],polled[2],polled[3]);
                for (int[] d : directions) {
                    int polledKeyStatus = polled[2];
                    int nr = d[0] + polled[0];
                    int nc = d[1] + polled[1];
                    //bound
                    if (nr < 0 || nr >= m || nc < 0 || nc >=n) continue;
                    //wall
                    if (board[nr][nc] == '#') continue;
                    //visited
                    if (visited[nr][nc][polledKeyStatus]) continue;
                    //lock..근데 검사안해도되는데?
                    if (board[nr][nc] >= 'A' && board[nr][nc] <= 'Z') {
                        int needed = board[nr][nc] - 'A';
                        if (((polledKeyStatus >> needed) & 1) != 1) continue;//hit the road dude
                    }
                    //key putif
                    if (board[nr][nc] >= 'a' && board[nr][nc] <= 'z') {
                        polledKeyStatus |= (1 << board[nr][nc] - 'a');
                    }
                    //RETURN CHECK
                    if (polledKeyStatus == goalBit) return polled[3] + 1;
                    //continue: pq offer visited
                    visited[nr][nc][polledKeyStatus] = true;
                    q.offer(new int[] {nr, nc, polledKeyStatus, polled[3] + 1});
                }
            }

        }
        return -1;
        
    }
}
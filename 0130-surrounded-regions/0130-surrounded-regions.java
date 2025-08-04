class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    int rows, cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') bfs(board, i , 0);
            if (board[i][cols-1] == 'O') bfs(board, i, cols - 1);
        }
        for (int i = 0; i < cols; i++) {

            if(board[0][i] == 'O') bfs(board, 0 , i);
            if (board[rows - 1][i] == 'O')bfs(board, rows - 1, i);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '$') board[i][j] = 'O';
            }
        }
        return;
    }
    public void bfs(char[][] board, int r, int c) {
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        q.offer(new int[] {r,c});
        visited[r][c] = true;
        board[r][c] = '$';

        while (!q.isEmpty()) {
            int[] polled = q.poll();
            for (var d : directions) {
                int nr = d[0] + polled[0];
                int nc = d[1] + polled[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || board[nr][nc] == 'X' || visited[nr][nc]) continue;
                
                q.offer(new int[] {nr,nc});
                //System.out.print(nr+","+nc+" flipped ");
                visited[nr][nc] = true;
                board[nr][nc] = '$';
                //System.out.println(board[nr][nc] + " ");
            }
        }
    }
}
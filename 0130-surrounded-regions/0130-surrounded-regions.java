class Solution {
    int m, n;
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {

        m = board.length;
        n=  board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i,0);
            dfs(board, i,n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') board[i][j] = 'O';
                else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
            //System.out.printf("passing [%d][%d]\n", r,c);
            return;
            } //O면 방문, 아니면 1.X는 패스 2.#는 이미 방문함

        board[r][c] = '#';// O를임시로 바꿔놓음
        //System.out.printf("[%d][%d] == #\n", r, c);
        for (int[] d : directions) {
            dfs(board, r + d[0], c + d[1]);
        }
    }
}
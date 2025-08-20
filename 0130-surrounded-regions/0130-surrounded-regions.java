class Solution {
    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i,0);
            dfs(board, i,n-1);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') board[i][j] = 'O'
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    public void dfs(char[][]board,  int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') return;

        board[r][c] = '#';
        dfs(board, r + 1, c);
        dfs(board, r + 1, c);
        dfs(board, r + 1, c);

    }
}
/**
먹히는 거 찾아야하니까
역으로 안먹히는 거 찾으면 됨
    가장자리 O에서 dfs/bfs해서 연결되는 O들은 안지워짐.
    연결되는 애들을 #로 표시하고
    가운데(가장자리 빼고) 순회하면서 #애들은 O로 만들고 그냥 O들은 X로 바꿈
 */
class Solution {
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    int m, n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, i, j, 0, word)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, boolean[][] visited, int r, int c, int idx, String word) {
        // System.out.printf("checking %d, %d to see if board[%d][%d] equals %c \n", r, c, r, c, word.charAt(idx));
        // System.out.printf("idx = %d\n", idx);
        if (board[r][c]  !=  word.charAt(idx)) return false;
        if (idx == word.length() - 1) return true; //마지막 인덱스면 완성
        visited[r][c] = true;
        // System.out.printf("Matched!visited %c\n", board[r][c]);
        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
            if (visited[nr][nc]) continue;
            
            //System.out.printf("Filter passed, checking adjacent directions for %d %d \n", r, c);
            if (dfs(board, visited, nr, nc, idx + 1, word)) return true;
            else continue;
        }
        visited[r][c] = false;
        return false;
    }
}
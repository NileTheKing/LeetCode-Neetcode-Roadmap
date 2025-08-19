class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(board, new boolean[m][n], i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, boolean[][] visited, int r, int c, String word, int idx) {
        if (r >= m || r < 0 || c >= n || c < 0 || visited[r][c]) return false;
        if (idx == word.length() || (idx == word.length() -1  && board[r][c] == word.charAt(idx))) return true;
        if (board[r][c] != word.charAt(idx)) return false;
        visited[r][c] = true;
        //sb.append(board[r][c]);
        //System.out.printf("current: %s \n", sb.toString());
        if (dfs(board, visited, r + 1, c, word, idx + 1) ||
        dfs(board, visited, r -1, c, word, idx + 1) ||
        dfs(board, visited, r, c + 1, word, idx + 1) ||
        dfs(board, visited, r, c - 1, word, idx + 1)) return true;

        visited[r][c]=  false;
        return false;
    }
}
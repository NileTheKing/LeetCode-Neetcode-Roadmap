class Solution {
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n =  board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(word, 0, i, j, new boolean[m][n], board)) return true;
            }
        }
        return false;
    }
    public boolean dfs(String word, int index, int r ,int c, boolean[][] visited, char[][] board) {
        if (index == word.length()) return true;
        if (r < 0 || r >= m || c < 0 || c >= n) return false;
        if (visited[r][c]) return false;
        if (board[r][c] != word.charAt(index)) return false;

        visited[r][c] = true;
        for (int[] d : directions) {
            int nr = d[0] + r;
            int nc = d[1] + c;

            if (dfs(word, index + 1, nr ,nc, visited, board)) return true;
        }
        visited[r][c] = false;

        return false;
    }
}
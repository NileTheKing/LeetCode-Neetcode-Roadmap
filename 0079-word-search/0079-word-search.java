class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {

        //boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if (dfs(board, word, 1, visited, i, j)) {
                        //System.out.println("got true");
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int idx, boolean[][] visited, int r, int c) {
        if (idx == word.length()) { //System.out.println("returning true"); 
        return true;}

        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= board.length || nr < 0 || nc >= board[0].length || nc < 0 || visited[nr][nc]) continue;
            if (board[nr][nc] != word.charAt(idx)) continue;
            //System.out.println("visiting [" + nr + ", " + nc);
            visited[nr][nc] = true;
            if (dfs(board, word, idx + 1, visited, nr, nc)) return true;
            visited[nr][nc] = false;
        }
        
        return false;
    }
}
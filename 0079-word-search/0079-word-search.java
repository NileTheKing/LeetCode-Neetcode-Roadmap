class Solution {
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    int m,n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, new int[]{i,j}, new boolean[m][n], word, 0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int[] coord, boolean[][] visited, String word, int idx) {
        
        if (word.charAt(idx) != board[coord[0]][coord[1]]) return false;
        if (idx == word.length()- 1) return true; //같고 마지막에 도달했는지

        visited[coord[0]][coord[1]] = true;
        for (int[] direction : directions) {
            int nr = coord[0] + direction[0];
            int nc = coord[1] + direction[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                if (dfs(board, new int[]{nr,nc}, visited, word, idx + 1)) {
                    return true; // 만약 재귀 호출에서 단어를 찾았으면, 즉시 true를 반환하여 상위 호출로 전달
                }
            }
        }
        //여기까지 왔다면 답없는거임
        visited[coord[0]][coord[1]] = false;
        return false;
    }
}
/**
board를 순회하며 word에 맞는 지점을 따라 이동


 */
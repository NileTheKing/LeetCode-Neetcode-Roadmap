//https://neetcode.io/problems/islands-and-treasure?list=neetcode150
class Solution {
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    int rows, cols;
    int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == INF)
                    grid[i][j] = bfs(grid, i, j, new boolean[rows][cols]);
            }
        }
        return;
    }
    public int bfs(int[][] grid, int r, int c, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        visited[r][c] = true;

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] polled = q.poll();
                for (int[] direction : directions) {
                    int nr = polled[0] + direction[0];
                    int nc = polled[1] + direction[1];

                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc] || grid[nr][nc] == -1) continue;
                    if (grid[nr][nc] == 0) return steps;
                    q.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return INF; // 못찾으면
    }
}

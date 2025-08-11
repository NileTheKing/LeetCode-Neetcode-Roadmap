class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        //pacific to uphill
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) { //|
            bfs(heights, pacific, i, 0);
        }
        for (int i = 0; i < n; i++) { // -
            bfs(heights, pacific, 0, i);
        }
        //atlantic to uphill
         for (int i = 0; i < m; i++) { // |
            bfs(heights, atlantic, i, n-1);
        }
        for (int i = 0; i < n; i++) {// -
            bfs(heights, atlantic, m-1, i);
        }
        //intersection
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    public void bfs(int[][] heights, boolean[][] reachable, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        //boolean[][] visited = new boolean[m][n];
        q.offer(new int[] {r,c});
        //visited[r][c] = true;
        reachable[r][c] = true;

        while (!q.isEmpty()) {
            int[] polled = q.poll();
            for (var d : directions) {
                int nr = polled[0] + d[0];
                int nc = polled[1] + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n || reachable[nr][nc]) continue;
                if (heights[polled[0]][polled[1]] <= heights[nr][nc]) {
                    q.offer(new int[] {nr,nc});
                    reachable[nr][nc] = true;
                    //visited[nr][nc] = true;
                }
            }
        }
    }
}
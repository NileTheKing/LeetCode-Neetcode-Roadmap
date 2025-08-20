class Solution {
    int m, n;
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n-1);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, 0, i);
            dfs(heights, atlantic, m-1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;


    }
    public void dfs(int[][] heights, boolean[][] ocean, int r, int c) {
        if (ocean[r][c]) return;

        ocean[r][c] = true;

        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= m || nc < 0 || nc >=n  || heights[r][c] > heights[nr][nc]) continue;
            dfs(heights, ocean, nr, nc);
        }
        return;
        
    }
}
/**

 */
class Solution {
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n]; //
        boolean[][] atlantic = new boolean[m][n];
        
        
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, 0);
            dfs(heights, atlantic, i, n-1,0);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, 0, i, 0);
            dfs(heights, atlantic, m-1, i,0);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atlantic[i][j] && pacific[i][j])  {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;

    }
    public void dfs(int[][] heights, boolean[][] ocean, int r, int c, int prev) {
        if (r < 0 || r >= m || c < 0 || c >= n || ocean[r][c] || heights[r][c] < prev) return; //미방문이 아니라면(불가능, 가능) back
        // if (heights[r][c] < prev) {
        //     ocean[r][c] = -1; //미방문 칸이지만 니지만 현재 칸이 유효하지 않으므로 << 섣부른 결정임.
        //     System.out.printf("cell[%d][%d] is inavailable\n", r, c);
        //     return;
        // }
        ocean[r][c] = true;
        dfs(heights, ocean, r + 1, c, heights[r][c]);
        dfs(heights, ocean, r - 1, c, heights[r][c]);
        dfs(heights, ocean, r, c + 1, heights[r][c]);
        dfs(heights, ocean, r, c - 1, heights[r][c]);
        
    }
}
/**
모든 cell에서 하는 거 보다 edge에서 역으로 가서 겹치는 부분 return
 */
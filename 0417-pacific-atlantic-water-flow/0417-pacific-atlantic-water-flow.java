class Solution {
    int m, n;
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        
        for (int i = 0; i < m; i++) {
            System.out.println("start of pacific |");
            dfs(heights,pacific, i, 0, -1);
            System.out.println("end of pacific |");
            dfs(heights,atlantic, i, n-1, -1);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights,pacific, 0, i, -1);
            dfs(heights,atlantic, m-1, i, -1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) ans.add(Arrays.asList(i,j));
            }
        }

        return ans;
    }
    public void dfs(int[][] heights, boolean[][] ocean, int r , int c, int prevHeight){
        // if (r < 0 || r >= m || c < 0 || c >= n || ocean[r][c]) return;
        // if(heights[r][c] < prevHeight) return;
        System.out.printf("visiting[%d][%d] ", r,c);
        ocean[r][c] = true;
        for (int[] d : directions) {
            int nr = d[0] + r;
            int nc = d[1] + c;
            if (nr < 0 || nr >= m || nc < 0 || nc >= n ) {
                // System.out.printf("out of bound skip. at [%d][%d]\n", nr,nc);
                continue;
            }
            if (ocean[nr][nc]) {
                //System.out.printf("visited[%d][%d] already \n", nr,nc);
                continue;
            }
            if (heights[r][c] > heights[nr][nc]) {
                //System.out.printf("cell ur going visit [%d][%d] should be higher but lower than [%d][%d]\n", nr,nc,r,c);
                continue;
            }
            dfs(heights, ocean, nr, nc, heights[r][c]);
        }
    }
}
/**
전체 셀에 대해 탐색하는 것 보다
pacific, atalntic edges에서 역으로 올라가서 각각 마킹하고 겹치는 부분 찾는게 더 빠룸.

 */
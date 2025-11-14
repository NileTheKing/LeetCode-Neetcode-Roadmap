class Solution {
    int m, n;
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        //ㅣㅣ방문, 둘다
        for (int i = 0; i  < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n-1);
        }
    
        //= 방문  둘다
        for (int i = 0; i  < n; i++) {
            dfs(heights, pacific, 0, i);
            dfs(heights, atlantic, m-1, i);
        }
        //둘다되는거  찾기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }

    public void dfs(int[][] heights, boolean[][] ocean, int r, int c) {
        if (ocean[r][c]) return; //여기가 가능하다는거는 이 뒤로도 처음왔을때 다 봤을거니까 그만

        ocean[r][c] = true;

        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
            if (heights[nr][nc] < heights[r][c]) continue;
            dfs(heights, ocean, nr , nc);
        }

    }
}
class Solution {
    int m, n;
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            //pacific 세로
            //System.out.println("====start of pacific=====");
            dfs(heights, pacific, i, 0);
            //atlantic 세로
           // System.out.println("====start of atlantic=====");
            dfs(heights, atlantic, i, n-1);
        }
        for (int i = 0; i < n; i++) {
            //pacific 가로
           // System.out.println("====start of pacific=====");
            dfs(heights, pacific, 0, i);
            //atnalntic 가로
            //System.out.println("====start of atlantic=====");
            dfs(heights, atlantic, m-1, i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;

    }
    public void dfs(int[][] heights, boolean[][] visited, int r, int c) {

        visited[r][c] = true;
        //System.out.printf("visiting %d, %d\n", r, c);
        for (int[] d : directions) {
            int nr = r + d[0];
            int nc=  c + d[1];
            
            if (nr <0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) continue;
            if (heights[nr][nc] < heights[r][c]) continue;
            dfs(heights, visited, nr, nc);
        }
    }
}
/**
근데 그냥 하나씩 돌아보면 안되나?
실제로 되는 애들은 미리 마킹해놓는거지]
pacific이랑 atlantic 갈 수 있는 애들을 다 담아놓는거고
아니면 반대로 안되는애들 싹 다 담아놓고 (VISITED느낌으로) ㅇ안되는 칸에 오면 순회를 포기하는거지

자그럼 왼쪽위부터 간다치면 
 */
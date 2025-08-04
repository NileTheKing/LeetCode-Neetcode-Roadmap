class Solution {
    int[][] directions = {{1,0},{-1,0}, {0,1}, {0,-1}};
    int r, c;
    public int maxAreaOfIsland(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        int max= 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    max=  Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {

        if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] != 1) {
            return 0;
        }
        int cnt = 1;
        grid[i][j] = 2;
        for (int[] direction : directions) {
            cnt += dfs(grid, i + direction[0], j + direction[1]);
        }
        return cnt;
    }
}
class Solution {
    int[][] directions = {{-1, 0},{0, 1}, {0, -1}, {1, 0}};
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        //boolean[][] visited = new boolean[m][n];
        //List<List<int[]>> islands = new ArrayList<>();
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    bfs(grid,  i, j);
                    ans++;
                }
            }
        }
        

        return ans;
    }

    public void bfs(char[][] grid, int r, int c) {
    

        Queue<int[]> queue = new LinkedList<>();
        //List<int[]> list = new ArrayList<>();
        queue.offer(new int[] {r,c});
        //list.add(coord);
        grid[r][c] = 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) { //큐에 있는 모든 좌표에 대하여
                //주변 탐색
                int[] polled = queue.poll();
                for (int[] direction : directions) {
                    int nr = polled[0] + direction[0];
                    int nc = polled[1] + direction[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >=n) continue;//초과라서 이쪽방향은 안됨
                    if (grid[nr][nc] != '1') continue;

                    //가능한 좌표면 추가. 상대좌표? 필요없지. 너가 풀었던 문제는 다른 보드에 적용해야 됐던 문제잖아
                    //큐에도 추가
                    queue.offer(new int[]{nr, nc});
                    //list.add(new int[]{nr, nc});
                    grid[nr][nc] = '2';

                }
            }
        }

    }
}
/**
어쨌든 순회를 해야한다.
graph를 dfs든 bfs해서 상대좌표 기준으로 hashset에다가 하고
마지막에 set에 있는 갯수를 리턴하면 된다.
 */
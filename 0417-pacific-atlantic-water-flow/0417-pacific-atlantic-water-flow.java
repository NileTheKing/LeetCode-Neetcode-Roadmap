class Solution {
    int rows, cols;
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        rows = heights.length;
        cols = heights[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (bfs(heights,i,j))
                    ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }
    public boolean bfs(int[][] heights, int r, int c) {
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;
        boolean flag1 = false;
        boolean flag2 = false;
        while (!q.isEmpty()) {
            int[] polled = q.poll();
            for (int[] d : directions) {
                int nr = polled[0] + d[0];
                int nc = polled[1] + d[1];


                if (nr < 0 || nc < 0) flag1 = true;
                if (nr >= rows || nc >= cols) flag2 = true;

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || heights[nr][nc] == -2 || visited[nr][nc]) continue; //불가능
                if (heights[polled[0]][polled[1]] < heights[nr][nc]) continue;//불가능

                visited[nr][nc] = true;
                q.offer(new int[] {nr,nc});
            }
        }

        return flag1 && flag2;
    }
}
/**
각 지점을 순회
둘다 도달가능하면 추가. 아니라면 패스..
일단 그렇게 풀어볼까? 나중에 최적화는 또.. 현재 위치가 되는 위치면 더 확인할 필요 없긴하지.
반대로 안되는 위치면 
 */
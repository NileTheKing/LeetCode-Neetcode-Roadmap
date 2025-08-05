class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        int cnt = 0;

        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                dfs(map, visited, i);
                cnt++;
            }
        }
        return cnt;
    }

    public void dfs(Map<Integer, List<Integer>> map, boolean[] visited, int current) {
        if (visited[current]) return;

        visited[current] = true;
        for (int nei : map.getOrDefault(current, new ArrayList<>())) {
            dfs(map, visited, nei);
        }
        return;
    }
}
/**
easy

갯수 세면 되는 거자놓아
연결해놓고
방문처리하면서 for문만큼 dfs학 ㅗ카운트 늘림
dfㄴ할때만 카운트하면 됨
*/

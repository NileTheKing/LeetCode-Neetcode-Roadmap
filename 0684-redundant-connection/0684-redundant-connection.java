class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = edges.length;

        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);

            boolean[] visited = new boolean[n+1];

            if (dfs(map, e[0], -1, visited)) return new int[] {e[0],e[1]};
        }
        return null;


    }
    public boolean dfs(Map<Integer, List<Integer>> map, int current, int parent, boolean[] visited) {
        if (visited[current]) return true;//싸이클 발견. 답 리턴
        //System.out.println(current + " traversing.");
        visited[current] = true;
        for (int nei : map.getOrDefault(current, new ArrayList<>())) {
            if (nei == parent) continue;
            if (dfs(map, nei, current, visited)) return true;

        }
        return false; //존재하지 않음
    }
}
/**
dfs해서 싸이클 찾아라 이거네.그거 간선 찾으면 됨
일단 이거는 다 연결은 되어있지.
그니까 1로 단일 진입하면 됨.
그러니까 딱히 visited할필요 없이 cycle 가지고 있으면 될듯?
 */
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> cycle = new HashSet<>();
    boolean[] visited;
    int cycleStart = -1;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        visited = new boolean[n+1];
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
    
        dfs(1, -1);

        for (int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (cycle.contains(u) && cycle.contains(v)) return new int[] {u,v};
        }
        return new int[0];
    }
    public boolean dfs(int current, int parent) {
        if (visited[current] == true) {
            cycleStart = current;
            return true;

        }
        visited[current] = true;

        for (int nei : map.getOrDefault(current, new ArrayList<>())) {
            if (nei == parent) continue;
            if (dfs(nei, current)) {
                if (cycleStart != -1) cycle.add(current); //싸이클에 들어가는 놈임
                if (current == cycleStart) {
                    cycleStart = -1;
                }
                return true;
            }
        }
        return false;
    }
}
/**
dfs해서 싸이클 찾아라 이거네.그거 간선 찾으면 됨
일단 이거는 다 연결은 되어있지.
그니까 1로 단일 진입하면 됨.
그러니까 딱히 visited할필요 없이 cycle 가지고 있으면 될듯?
 */
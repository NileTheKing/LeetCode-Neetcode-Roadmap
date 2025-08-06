class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        return dfs(map, 1, -1, new HashSet<>());
    }
    public int[] dfs(Map<Integer, List<Integer>> map, int current, int parent, Set<Integer> cycle) {
        if (cycle.contains(current)) return new int[] {current, parent};//싸이클 발견. 답 리턴
        System.out.println(current + " traversing.");
        cycle.add(current);
        for (int nei : map.getOrDefault(current, new ArrayList<>())) {
            if (nei == parent) continue;
            int[] ans = dfs(map, nei, current, cycle);
            if (ans != null) return ans;

        }
        return null; //존재하지 않음
    }
}
/**
dfs해서 싸이클 찾아라 이거네.그거 간선 찾으면 됨
일단 이거는 다 연결은 되어있지.
그니까 1로 단일 진입하면 됨.
그러니까 딱히 visited할필요 없이 cycle 가지고 있으면 될듯?
 */
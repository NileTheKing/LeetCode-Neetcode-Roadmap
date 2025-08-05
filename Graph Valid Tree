class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        //그래프를 인접리스트로 만들고 순회 돌림.
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        if (cycleDetected(map, 0, -1)) return false;
        return visited.size() == n;
    }
    public boolean cycleDetected(Map<Integer, List<Integer>> map, int current, int parent) {
        if (visited.contains(current)) return true;
        
        visited.add(current);
        for (int nei : map.getOrDefault(current, new ArrayList<>())) {
            if (nei == parent) continue;
            if(cycleDetected(map, nei, current)) return true;
        }
        return false;
    }
}
/**
tree = graph with no cycle.
*/

class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        visited = new HashSet<>();
        for (int[] pre : prerequisites) {
            int v1 = pre[0];
            int v2 = pre[1];
            map.computeIfAbsent(v1, v -> new ArrayList<>()).add(v2);
        }

        //multiple entry points
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(prerequisites, i, new HashSet<>())) return false;
        }

        return visited.size() == numCourses;
    }

    public boolean hasCycle(int[][] prerequisites, int current, Set<Integer> visiting) {
        if (visiting.contains(current)) {
            return true;
        }
        if (visited.contains(current)) return false;

        visiting.add(current);
        for (int nei : map.getOrDefault(current, new ArrayList<>())) {
            if (visited.contains(nei)) continue;//이미 방문했던 애들은 안함
            if (hasCycle(prerequisites, nei, visiting)) return true;
        }
        visiting.remove(current);
        visited.add(current);
        return false;
    }
}/**
if there is a cycle int the graph, return false
from multiple entries, check if there is a cycle made thru the travesal
 */
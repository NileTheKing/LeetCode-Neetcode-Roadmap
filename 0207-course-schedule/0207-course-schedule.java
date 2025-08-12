class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    boolean[] visited;// no cycle assured
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        for (int[] p : prerequisites) {
            map.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(map, new HashSet<>(), i)) return false;
        }
        return true;

    }
    public boolean hasCycle(Map<Integer, List<Integer>> map, Set<Integer> visiting, int current) {
        if (visiting.contains(current)) return true;
        if (visited[current]) return false;

        visiting.add(current);
        for (var nei : map.getOrDefault(current, new ArrayList<>())) {
            if (hasCycle(map, visiting, nei)) return true;
        }
        visiting.remove(current);
        visited[current] = true;
        return false;
    }
}
/**
graph problem
a->b 로 그려야함. 왜냐하면 역순으로 찾아야함. 싸이클 찾기
 */
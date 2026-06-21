class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : prerequisites) {
            int v1 = p[0];
            int v2 = p[1];
            //v2 -> v1
            map.computeIfAbsent(v2, k -> new ArrayList<>()).add(v1);
        }
        //그래프 순회하면서 싸이클 발견..

        for (int i = 0; i < numCourses; i++) {
            if (visited.contains(i)) continue;
            // System.out.printf("===start of detection at %d====\n", i);
            if(findCycle(map, i, new HashSet<>())) {
                // System.out.printf("cycle detected! %d\n", i);
                return false;
            }
        }
        // System.out.printf("size: %d\n", visited.size());
        return visited.size() == numCourses ? true : false;
    }
    public boolean findCycle(Map<Integer, List<Integer>> map, int current, Set<Integer> visiting) {
        if (visiting.contains(current)) return true;
        // System.out.printf("visiting %d\n", current);
        visiting.add(current);
        for (int nei : map.getOrDefault(current, List.of())) {
            if (visited.contains(nei)) continue;
            if (findCycle(map, nei, visiting)) return true;
        }
        visited.add(current);
        return false;
    }
}
/**
prerequisites[i] = [ai, bi] bi -> ai
numCourses: 전체 수업수
prerequisites: 조건
 */
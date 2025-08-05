class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int[] p : prerequisites) {
            map.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(!dfs(i, map, visited, res, new HashSet<>())) return new int[0];
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    public boolean dfs(int current, Map<Integer, List<Integer>> map,  Set<Integer> visited, List<Integer> res, Set<Integer> cycle) {
        if (visited.contains(current)) return true;
        if (cycle.contains(current)) return false;


        cycle.add(current);

    
            for (int nei : map.getOrDefault(current, new ArrayList<>())) {
                if (!dfs(nei, map, visited,res, cycle)) return false;
            }

        visited.add(current);
        cycle.remove(current);
        res.add(current);
        return true;
    }
}
/**
순회를 해서 방문 경로를 추적. 다 방문하면 그걸 리턴
불가능하면(싸이클 생기면) empty array 리턴
    불가능한건
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        for (int[] p : prerequisites) {
            map.computeIfAbsent(p[0], k-> new ArrayList<>()).add(p[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited.contains(i)) continue;
            if (!dfs(i, new HashSet<>())) return new int[0];
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
    public boolean dfs(int current, Set<Integer> visiting) {
        if (visiting.contains(current)) return false;
        if (visited.contains(current)) return true;

        visiting.add(current);
        for (int nei : map.getOrDefault(current, new ArrayList<>())) {
            if (!dfs(nei, visiting)) return false;
        }
        
        visiting.remove(current);
        visited.add(current);
        ans.add(current);
        return true;
    }
}
/**
백트래킹과 그래프 순회
일단 순서는 상관없으니 모든 지점에서 entry해야함
그리고 음 뒤에서부터 순서를 dfs에서 넣어야하는데 그거를 어떻게하지?
list에 추가하면 되겟네
 */
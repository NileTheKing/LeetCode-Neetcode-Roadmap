class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> visited;
    List<Integer> ans;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        visited = new HashSet<>();
        ans = new ArrayList<>();

        for (int[] p : prerequisites) {
            map.computeIfAbsent(p[0], v -> new ArrayList<>()).add(p[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (takeCourse(prerequisites, i, new HashSet<>())) return new int[0];
        }

        return ans.stream().mapToInt(i->i).toArray();
    }
    //if true it has cycle
    public boolean takeCourse(int[][] prerequisites, int current, Set<Integer> visiting) {
        if (visiting.contains(current)) return true;
        if (visited.contains(current)) return false;

        visiting.add(current);
        for (int nei : map.getOrDefault(current, new ArrayList<>())) {
            if (takeCourse(prerequisites, nei, visiting)) return true;
        }
        visited.add(current);
        visiting.remove(current);
        ans.add(current);
        return false;
    }
}
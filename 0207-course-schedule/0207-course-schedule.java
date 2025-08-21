class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int[] pr : prerequisites) {//graph 완성
            map.computeIfAbsent(pr[0], k-> new ArrayList<>()).add(pr[1]);
        }      

        //모든 노드를 순회하며 사이클 확인. 방향그래프므로 parent없이 그냥 방문중인 노드 발견하면 cycle.
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i) && hasCycle(new HashSet<>(), i)) {
                // System.out.printf("%d has cycle", i);
                return false;
            }
        }
        return true;
    }
    public boolean hasCycle(Set<Integer> visiting, int current) {
        if (visiting.contains(current)) {
            // System.out.print("has been visitng: ");
            // for (Integer i : visiting) {
            //     System.out.printf("%d, ", i);
            // }
            // System.out.printf("and %d is the problem \n", current);
            return true;
        }
        if (visited.contains(current)) return false;

        visiting.add(current);

        for(int nei : map.getOrDefault(current, new ArrayList<>())) {
            if (hasCycle(visiting, nei)) return true;
        }
        visiting.remove(current);
        visited.add(current);
        return false;
    }
}
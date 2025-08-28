class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> cycle = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    public int[] findRedundantConnection(int[][] edges) {
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);

            findCycles(e[0], -1, new HashSet<>());
            if(cycle.contains(e[0]) && cycle.contains(e[1])) {
                return e;
            }
        }
        


        return new int[0];
    }
    public void findCycles(int current, int parent, Set<Integer> visiting) {
        if (visiting.contains(current)) {
            for (int n : visiting) {
                cycle.add(n);
                //System.out.printf("cycle added: %d\n", n);
            }
            return;
        }
        //if (visited.contains(current)) return;
        
        System.out.printf("visiting %d \n", current);
        visiting.add(current);
        for (int nei : map.getOrDefault(current, new ArrayList<>())) {
            if (nei != parent) {
                findCycles(nei, current, visiting);
            }
        }
        visiting.remove(current);
        visited.add(current);
        return;
    }
}
/**
cycle detection으로 가자. cycle ds에  넣어두고 edges input을 뒤로부터 실행해서 싸이클
 */

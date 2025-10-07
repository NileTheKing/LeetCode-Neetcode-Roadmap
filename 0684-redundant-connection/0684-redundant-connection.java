class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    //Set<Integer> cycle = new HashSet<>();
    //Set<Vertice> cycles = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    public int[] findRedundantConnection(int[][] edges) {
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);

            if (visited.contains(e[0]) && visited.contains(e[1])) return e;
            traverse(e[0], -1, new HashSet<>());
            traverse(e[1], -1, new HashSet<>());
        }

        return new int[0];
    }
    public void traverse(int current, int parent, Set<Integer> visiting) {
        if (visiting.contains(current)) {
            return;
        }
        if (visited.contains(current)) return;
        
        //System.out.printf("%d to %d\n", parent, current);
        visiting.add(current);
        
        for (int nei : map.getOrDefault(current, List.of())) {
            if (nei != parent) traverse(nei, current, visiting);
        }
        visiting.remove(current);
        visited.add(current);

        return;
    }
}

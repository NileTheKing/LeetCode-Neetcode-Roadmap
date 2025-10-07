class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Vertice> cycles = new HashSet<>();
    //Set<Integer> visited = new HashSet<>();
    public int[] findRedundantConnection(int[][] edges) {
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        for (int i = 1; i < edges.length; i++) {
            hasCycle(edges[i][0], -1, new HashSet<>());
        }
        for (int i = edges.length - 1; i >= 0; i--) {
            if (cycles.contains(new Vertice(edges[i][0], edges[i][1])) || cycles.contains(new Vertice(edges[i][1], edges[i][0]))) return new int[] {edges[i][0], edges[i][1]};
        }

        return new int[0];
    }
    public void hasCycle(int current, int parent, Set<Integer> visiting) {
        if (visiting.contains(current)) {
            cycles.add(new Vertice(current, parent));
            //System.out.printf("%d %d cycle\n", current, parent);
            return;
        }
        //if (visited.contains(current)) return;
        
        //System.out.printf("%d to %d\n", parent, current);
        visiting.add(current);
        
        for (int nei : map.getOrDefault(current, List.of())) {
            if (nei != parent) hasCycle(nei, current, visiting);
        }
        visiting.remove(current);
        //visited.add(current);

        return;
    }
    public class Vertice {
        int v1;
        int v2;

        Vertice(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertice v = (Vertice) o;
            return this.v1 == v.v1 && this.v2 == v.v2;
        }
        @Override
        public int hashCode() {
            return Objects.hash(v1, v2);
        }
    }
}

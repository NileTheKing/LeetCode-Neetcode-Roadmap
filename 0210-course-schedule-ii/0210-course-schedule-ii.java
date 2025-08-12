class Solution {
    List<Integer> ans;
    Set<Integer> visited;
    Map<Integer, List<Integer>> map;
    int n;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        n = numCourses;
        map = new HashMap<>();
        ans = new ArrayList<>();
        visited = new HashSet<>();
        
        for (int[] p : prerequisites) {
            map.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }
        
        for (int i = 0; i < n; i++) {
            if (!isValid(new HashSet<>(), i, visited))
                return new int[0];
        }
        return ans.stream().mapToInt(a->a).toArray();
    
    }
    public boolean isValid(Set<Integer> visiting ,int current, Set<Integer> visited) {
        //System.out.println("currnet:" + current);
        if (visited.contains(current)) {
            //System.out.println("size condition ");
            System.out.println("already visited and assured");
            return true;
        }
        if (visiting.contains(current)) { 
            //System.out.println("cycle detected"); 
            return false;}
         //cycle detected
        
        visiting.add(current);


        for (var nei : map.getOrDefault(current, new ArrayList<>())) {
            System.out.println("nei:" +  nei);
            if (!isValid(visiting, nei,visited)) return false;
        }
        
        System.out.println(current + " added to visited");
        visited.add(current);
        visiting.remove(current);
        //System.out.println("reached end. coudlnt find. current: " + current);
        ans.add(current);
        return true;

    }
}
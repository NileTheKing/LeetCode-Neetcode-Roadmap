class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) { //[1,0] 이면 1->0
            if (!graph.containsKey(p[0])) {
                graph.put(p[0], new ArrayList<>());
            }
            graph.get(p[0]).add(p[1]);
        }

        //이제 사이클을 찾아야 함. 순회하면서(bfs) 방문처리 다되면 없는거고 방문안된 거 있으면 싸이클이 있음.
        //해시맵의 크기랑 관련이 있나 -> X

        //순회하면서 싸이클 찾아야함. 생각나는 방법은 bfs나 dfs 
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, i, new HashSet<>(), new HashSet<>())) {
                //System.out.println(i + " makes cycle");
                return false;
            }
        }
        return true;



    }
    public boolean hasCycle(Map<Integer, List<Integer>> graph, int current, Set<Integer> visited, Set<Integer> path) {
        if (path.contains(current))  return true;
        if (visited.contains(current)) return false;

        visited.add(current);
        path.add(current);
        
        if (graph.containsKey(current)) {
            for (int nei : graph.get(current)) {
                if (hasCycle(graph, nei, visited, path)) return true;
                path.remove(nei);
            }
        }
        return false;
    }
}
/**
obviously this is a graph problem
so easy
implement the graph, try to traverse it if all nodes are visited return true.

find a cycle.

0 1 두개
1들으려면 0들어야 한다
0들으려면 1들어야 한다.
인덱스는 의미가 딱히 \.
그냥 순회하면서 그래프 연결.

1->4
2->

3->1
3->2
 */
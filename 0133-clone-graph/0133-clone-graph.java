/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>(); //진,짭
        Node current = node;//찐 진입점
        Queue<Node> q = new LinkedList<>(); //찐 방문할 노드들
        Set<Integer> visited = new HashSet<>(); //이미 방문했던 노드들
        q.offer(current);
        map.put(current, new Node(current.val));
        visited.add(current.val);
        while(!q.isEmpty()) {
            Node polled = q.poll();
            Node copy = map.get(polled);
            //System.out.printf("copying %d\n", polled.val);
            List<Node> copiedNei = new ArrayList<>();
            for (Node nei : polled.neighbors) {
                if (!visited.contains(nei.val)) {
                    visited.add(nei.val);    
                    q.offer(nei);
                }
                if(!map.containsKey(nei)) map.put(nei, new Node(nei.val));
                copiedNei.add(map.get(nei));
            }
            copy.neighbors = copiedNei;
        }
        return map.get(node);
    }
}
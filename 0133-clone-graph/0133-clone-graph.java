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
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(node);
        map.put(node, new Node(node.val));
        visited.add(node.val);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            Node copied = map.get(poll);
            // System.out.printf("copying %d\n", poll.val);
            List<Node> copiedNei = new ArrayList<>();
            
            for (Node nei : poll.neighbors) {
                if (!visited.contains(nei.val)) {
                    visited.add(nei.val);
                    q.offer(nei);
                }
                map.computeIfAbsent(nei, k -> new Node(k.val));
                copiedNei.add(map.get(nei));
            }
            copied.neighbors = copiedNei;
        }
        return map.get(node);
    }
}
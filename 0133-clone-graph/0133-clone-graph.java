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
        Map<Node, Node> weave = new HashMap<>();
        //Map<Integer, Node> map = new HashMap<>()
        Queue<Node> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(node);
        visited.add(node.val);
        weave.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node polled = q.poll();
            System.out.printf("===copying %d====\n", polled.val);
            List<Node> copiedNeigh = new ArrayList<>();
            List<Node> candidatesNeighbors = polled.neighbors;
            for (Node nei : candidatesNeighbors) {
                weave.computeIfAbsent(nei, k -> new Node(nei.val));
                copiedNeigh.add(weave.get(nei));
                if (!visited.contains(nei.val)) q.offer(nei);
                visited.add(nei.val);
                System.out.printf("added %d\n", nei.val);
            }
            weave.get(polled).neighbors = copiedNeigh;
        }
        return weave.get(node);
    }
}
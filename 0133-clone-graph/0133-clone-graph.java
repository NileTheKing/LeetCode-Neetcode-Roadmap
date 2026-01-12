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
        weave.put(node, new Node(node.val));
        Queue<Node> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(node.val);
        q.offer(node);
        while(!q.isEmpty()) {
            Node current = q.poll();
            Node copiedNode = weave.get(current);
            //System.out.printf("%d done\n", current.val);
            List<Node> copiedNeighbors = new ArrayList<>();

            
            for (Node nei : current.neighbors) {
                if (!visited.contains(nei.val)) {
                    q.offer(nei);
                    visited.add(nei.val);
                }
                //if (weave.containsKey(nei)) weave.put(nei,new Node(nei.val));
                if (!weave.containsKey(nei)) weave.put(nei, new Node(nei.val));
                copiedNeighbors.add(weave.get(nei));
            }
            
            copiedNode.neighbors = copiedNeighbors;
            //visited.add(current.val);
        }
        return weave.get(node);
    }
}

/**
원래 생각: 미리 다 위빙을 해두고 원본 따라가면서 복사본을 연결해주기
1go    : 매번 위빙하면서 따라가면서 복사뜨고 따라가는 애 복사본 이웃추가.
 */
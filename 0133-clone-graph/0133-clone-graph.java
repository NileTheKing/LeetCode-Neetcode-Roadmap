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
        q.offer(node);
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        Set<Node> visited = new HashSet<>();
        while (!q.isEmpty() && q.peek() != null) {//원본을 꺼내서 복사본을
            Node current = q.poll();
            //map.put(current, new Node(current.val));
            Node copy = map.get(current);
            List<Node> copiedNeighbors = new ArrayList<>();
            visited.add(current);
            for (Node nei : current.neighbors) {
                map.computeIfAbsent(nei, k -> new Node(nei.val));
                if (!visited.contains(nei)) q.offer(nei);
                copiedNeighbors.add(map.get(nei));
            }
            copy.neighbors = copiedNeighbors;
        }
        return map.get(node);
    }
}
/**
원래대로면 짝을 다 지어주고 그다음에 순회하면서 복사
복사: 
    카피를 map.get해서 꺼내오고
    거기의 neighbors<< 얘를 이제 기존 원본의 neighbors를 돌면서 map.get해서 하나씩 추가
    그로 마지막으로 리스트를 대입.
마무리.
 */
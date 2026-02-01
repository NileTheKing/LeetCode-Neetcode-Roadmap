class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Node> map = new HashMap<>();
        for (int[] e : edges) {
            if (!map.containsKey(e[0])) {
                Node n1 = new Node(e[0]);
                n1.parent = n1;
                map.put(e[0], n1);
            }
            if (!map.containsKey(e[1])) {
                Node n2 = new Node(e[1]);
                n2.parent = n2;
                map.put(e[1], n2);
            }

            if (find(map.get(e[1])).val == find(map.get(e[0])).val) {
                return new int[] {e[0], e[1]};
            }else {
                union(map.get(e[0]), map.get(e[1]));
            }
        }
        return new int[0];

    }
    public class Node {
        int val;
        Node parent;
        Node(int val) {
            this.val = val;
        }
    }
    public void union(Node n1, Node n2) { 
        Node p2 = find(n2);
        Node p1 = find(n1);
        p2.parent = p1;
        return;
    }
    public Node find(Node n) {
        if (n.val == n.parent.val) return n;
        else {
            n.parent = find(n.parent);
            return n.parent;
        }
    }
}
/**
1. union find
2. cycle detection (dfs)
 */
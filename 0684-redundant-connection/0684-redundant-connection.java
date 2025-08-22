class Solution {
    Map<Integer, Node> map = new HashMap<>();
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        //Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new Node(i, i));
        }
        for (int[] e : edges) {
            Node n1 = map.get(e[0]);
            Node n2 = map.get(e[1]);
            if (union(n1, n2)) return e;
        }
        return null;
        
    }
    class Node {
        int val;
        int parent;
        int rank;

        Node(int val, int parent) {
            this.val = val;
            this.parent = parent;
            this.rank = 1;
        }
    }
    public boolean union(Node n1, Node n2) {
        Node p1 = find(n1);
        Node p2 = find(n2);

        if (p1.val == p2.val) return true;

        if (p1.rank >= p2.rank) {
            p2.parent = p1.val;
            p1.rank += p2.rank;
        }else {
            p1.parent = p2.val;
            p2.rank += p1.rank;
        }
        return false;
    }
    public Node find(Node n) {
        if (n.parent == n.val) 
            return n;
        
        Node root = find(map.get(n.parent));
        n.parent = root.val;
        return root;
    }
    
}
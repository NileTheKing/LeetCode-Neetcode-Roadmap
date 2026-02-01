class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Node> map = new HashMap<>();
        for (int[] e : edges) {
            map.computeIfAbsent(e[0], k -> new Node(k));
            map.computeIfAbsent(e[1], k -> new Node(k));

            Node root1 = find(map.get(e[0]));
            Node root2 = find(map.get(e[1]));
            if (root1.val == root2.val) {
                return new int[]{e[0], e[1]};
            }else {
                union(root1, root2);
            }
        }
        return new int[0];
    }
    public class Node {
        int val;
        Node parent;
        Node(int val) {
            this.val = val;
            this.parent = this;
        }
    }
    public void union(Node n1, Node n2) {
        n2.parent = n1;
        return;
    }
    public Node find(Node n) {
        if (n.val == n.parent.val) return n;
        else {
            n.parent = find(n.parent);//path compression
            return n.parent;
        }
    }
}
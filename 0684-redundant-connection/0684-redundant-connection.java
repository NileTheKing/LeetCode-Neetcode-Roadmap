class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Node> map = new HashMap<>();
        for (int[] e : edges) {
        //map에서 n1, n2를 읽어서 없으면 만들고 있으면 조회한거 씀
        //find먼저 해 보고 n1,n2 union함
            if (!map.containsKey(e[0])) {
                Node n = new Node(e[0]);
                n.parent = n;
                map.put(e[0], n);
            }
            if (!map.containsKey(e[1])) {
                Node n = new Node(e[1]);
                n.parent = n;
                map.put(e[1], n);
            }
            Node n1 = map.get(e[0]);
            Node n2 = map.get(e[1]);
            if (find(n1).key == find(n2).key) return new int[] {e[0], e[1]};
            else {
                union(n1, n2);
            }
        }
        return null;
    }
    public class Node{
        Node parent;
        int key;

        Node(int key) {
            this.key = key;
        }
    }
    public Node find(Node n) { //find it's root until the end
        if (n.val != n.parent.val) {
            n.parent = find(n.parent);
        }
        return n.parent;
    }
    public void union(Node n1, Node n2) {
        Node root1 = find(n1);
        Node root2 = find(n2);

        root2.parent = root1;
        return;
    }
}
/**
this can be a union find problem
or simply cycle detection problem.
add every single cycles into a data structure then iterate thru the eges backwards.
 */
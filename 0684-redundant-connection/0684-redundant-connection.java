class Solution {
    Map<Integer, Node> map = new HashMap<>(); //매핑
    public int[] findRedundantConnection(int[][] edges) {
        
        //초기값
        for (int[] e : edges) {
            if (!map.containsKey(e[0])) {
                Node node = new Node(e[0]);
                node.parent = node;
                map.put(e[0], node);
            }
            if (!map.containsKey(e[1])) {
                Node node = new Node(e[1]);
                node.parent = node;
                map.put(e[1], node);
            }
        }


        //순회하면서 합치는데 언제 안합치나? 둘의 부모가 같으면 .. 다
        for (int[] e : edges) {
            Node root1 = find(map.get(e[0]));
            Node root2 = find(map.get(e[1]));

            //root값이 동일 -> 이미 연결되어있음
            if (root1.val == root2.val) return new int[] {e[0], e[1]};
            else { //아니라면 합치고 계속
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
        }
    }

    public Node find(Node n) {
        
        if (n.val == n.parent.val) return n;
        else return find(n.parent);
    }
    public void union(Node n1, Node n2) { //n1에 n2를 병합
        Node root1 = find(n1);
        Node root2 = find(n2);

        root2.parent = root1;
        return;
    }

    /**
    
    unionfind에서 사이클 나오는 경우?
     */
}
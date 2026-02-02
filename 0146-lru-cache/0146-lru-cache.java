class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        //map에서 찾아가지고 값 리턴
        //head업데이트
        Node node = map.get(key);
        if (node == null) return -1;
        delete(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {

        //기존 키 존재한다면
        if (map.containsKey(key)) {
            delete(map.get(key));
        }
        //크기떄문에 못 넣는 경우 자리 만들어주기
        else if(map.size() >= capacity) {
            Node toBeDeleted = tail.prev;
            delete(toBeDeleted);
            map.remove(toBeDeleted.key);
        }
        Node add = new Node(key, value);
        insert(add);
        map.put(key, add);
    }
    public class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            next = null;
            prev = null;//초기값
        }
    }
    public void delete(Node n) {
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
    }
    public void insert(Node n) {
        //head og -> head n og
        Node og = head.next;
        head.next = n;
        n.prev = head;
        n.next = og;
        og.prev = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
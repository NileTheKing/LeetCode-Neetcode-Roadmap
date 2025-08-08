class LRUCache {
    Map<Integer, Node> map;
    Node head; //mru
    Node tail; //lru
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            //System.out.println("got" + node.key);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        //추가 기능. 용량이 초과하면 지운다음에 넣고
        //용량있으면 추가. 없으면 지우고 넣기
        if (map.containsKey(key)) {
            //System.out.println("duplicate " + key);
            Node og = map.get(key);
            remove(og);
            Node fresh = new Node(key, value);
            map.put(key, fresh);
            insert(fresh);
        }
        if (map.size() >= capacity) {
            
            Node n = tail.prev;
            //System.out.print("capaover, evicting: " + n.key);
            //System.out.println(" bcuz lru is:" + n.key);
            remove(n);
            map.remove(n.key);
        }
        Node n = new Node(key, value);
        insert(n);
        map.put(key, n);
        return;
        
    }

    public void insert(Node node) {
        Node og_next = head.next;
        head.next = node;
        node.prev = head;
        node.next = og_next;
        og_next.prev = node;
    }
    public void remove(Node node) {
        // prev node next -> prev next
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {
    int capacity;
    int cnt;
    Node head; //head가 mru
    Node tail; // tail이 lru
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cnt = 0;
        map = new HashMap<>();
        
        //여기 헷갈림
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    //to do
    public void insert(Node node) {
        //lined list에 추가, lru 관리
        // head, head.next, node를 연결 -> head node head.next로

        Node ogFirst = head.next;
        head.next = node;
        node.prev = head;
        node.next = ogFirst;
        ogFirst.prev = node;

        //cnt++;
    }
    public void remove(Node node) {
        // tail.prev tail에서  tail.prev이 지울 node임
        
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        //map.remove(node.key);
        //cnt--;
    }
    public int get(int key) {
        if (!map.containsKey(key)) {
            //System.out.println("cache doesn't have the  key: " + key);
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            map.remove(key);
            cnt--;
        }
        else if (cnt == this.capacity) {
            //System.out.println("capa over");
            //System.out.println("lru removed:" + tail.val);
            Node toRemove = tail.prev;
            remove(toRemove);
            map.remove(toRemove.key);
            cnt--;
        }
        //System.out.println("key, value " + key + ", " + value + "added");
        cnt++;
        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);
    }
}
class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 /**
 hash에다가 저장해놓고 관리해야함
 그러면 lru는 어떻게 관리하나?
 -> linked list에서 head와 tail로 관리.
  */
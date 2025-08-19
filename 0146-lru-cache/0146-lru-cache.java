class LRUCache {
    int capacity;
    Node head; //mru
    Node tail; //lru
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            //mru로
            Node n = map.get(key);
            delete(n);
            insert(n);
            return map.get(key).val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        //사이즈도 보고 중복도 보고 삽입.
        //사이즈랑 중복중에 무엇을 먼저 보나? 예를 들어 크기가 최대인데 put하면 그냥 해야되지 그럼 일단 중복먼저지.
        //만약 사이즈를 먼저 보면 lru가 지워지고 나서 put이 되기 때문에 원치 않는 연산이 수행됨
        if (map.containsKey(key)) { //중복 처리. 새로 값 넣고 delete insert
            //System.out.println("duplicate detected: " + key);

            delete(map.get(key));
            map.remove(key);
            Node n = new Node(key,value);
            insert(n);
            map.put(key, n);
            return;
        }
        if (map.size() == capacity) { //lru 삭제하고(map에서도 지우고 리스트에서도 지우고), map과 list에 추가
        
            Node n = tail.prev; // 삭제될 노드
            //System.out.print("deleting: " + n.key + " due to capcity-over, ");
            delete(n);
            map.remove(n.key);
            //System.out.println("and putting:" + key + " after.");
            map.put(key, new Node(key,value));
            insert(map.get(key));
            return;
        }
        Node n = new Node(key, value);
        map.put(key, n);
        insert(n);
    }

    public class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public void delete(Node node) { //연결리스트에ㅓㅅ 가운데든 마지막이든 지우는 기능
        //prev node next 를 prev next로 바꿔야함
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev; 
        //return node;
    }
    public void insert(Node node) {//맨앞에 삽입. head, tail 관리
        //head head.next head.next.next를 head node head.next로 바꿔야함
        Node head_next=  head.next;

        head.next = node;
        node.prev = head;
        node.next = head_next;
        head_next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
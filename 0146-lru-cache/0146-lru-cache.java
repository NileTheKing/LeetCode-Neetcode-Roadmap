class LRUCache {
    Map<Integer, Node> cache;
    Node head; //recent
    Node tail; //least recent
    int capa;
    
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capa = capacity;
        this.head = new Node(0, 0);
        this.tail= new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    //newly added
    private void remove(Node node) { //노드삭제
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }
    private void insert(Node node) { //맨앞에 추가
        Node next = this.head.next; //맨앞 다음거. 우리가 할거는 head->next를 head->node->next로
        this.head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;

    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        //있으면 지우고 새로만드는걸로 동일과정
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > capa) {
            Node lru = this.tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
class Node{
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
/**
lru면은.. 뭐가 처음이고 마지막인지 어떻게 알지?
큐를 만들어놓고 사용하면 뺀다음에 다시 넣고.. < 불가능하지
그냥 hashmap해서 하면 지울떄가 문제임. 뭐가 lru인지 알 수가 없다.

 */
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
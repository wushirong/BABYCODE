public class LRUCache {
    private final int capacity;
    private int curCapacity = 0;
    private CacheNode head;
    private CacheNode tail;
    private HashMap<Object, CacheNode> map;
    
    private class CacheNode {
        CacheNode prev;
        CacheNode next;
        int val;
        int key;
        public CacheNode(int k, int v) {
            val = v;
            key = k;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        curCapacity = 0;
        map = new HashMap<Object, CacheNode>(capacity);
    }
    
    public int get(int key) {
        CacheNode cur = map.get(key);
        if(cur == null) return -1;
        else {
            move(cur);
            return cur.val;
        }
    }
    
    public void set(int key, int value) {
        CacheNode node = map.get(key);
        if(node == null) {
            node = new CacheNode(key, value);
            if(curCapacity < capacity) curCapacity++;
            else if(tail != null){
                map.remove(tail.key);
                removeTail();
            }
            move(node);
            map.put(key, node);
        }
        else {
            node.val = value;
            move(node);
            map.put(key, node);
        }
    }
    
    private void move(CacheNode node) {
        if(node == null || node == head) return;
        if(head == null || tail == null) {
            head = node;
            tail = node;
            return;
        }
        if(node == tail) tail = tail.prev;
        if(node.prev != null) node.prev.next = node.next;
        if(node.next != null) node.next.prev = node.prev;
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }
    
    private void removeTail() {
        if(tail != null) {
            if(tail.prev != null) {
                tail.prev.next = null;
            }
            else {
                head = null;
            }
            tail = tail.prev;
        }
    }
}
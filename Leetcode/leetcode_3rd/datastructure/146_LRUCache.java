class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode next;
    public DLinkedNode (int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head;
    private DLinkedNode tail;
    int count;
    int capacity;
    
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        head = new DLinkedNode(0, 0);
        tail = new DLinkedNode(0, 0);
        this.capacity = capacity;
        this.count = 0;
        head.pre = null;
        head.next = tail;
        tail.next = null;
        tail.pre = head;
    }
    
    //attempt to get a element from cache
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null){//element not in the cache
            return -1;
        }
        
        this.moveToHead(node);
        return node.value;
    }
    
    //attemp to set/get an element from cache
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null){//element is not in the cache
            DLinkedNode newNode = new DLinkedNode(key, value);
            this.cache.put(key, newNode);
            //add newNode right after head
            this.addNode(newNode);
            count++;
            //check capacity
            if (count > capacity){
                //Pop and return the element at the tail
                DLinkedNode last = this.popTail();
                this.cache.remove(last.key);
                count--;
            }
        } else { //element is current existing in the cache, then update the value and move it to head
            node.value = value;
            this.moveToHead(node);
        }
    }
    
    //add one node right after head
    private void addNode(DLinkedNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    
    //remove a node from list
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }
    
    //move one node to head
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }
    
    //pop the last node
    private DLinkedNode popTail(){
        DLinkedNode last = tail.pre;
        this.removeNode(last);
        return last;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    // head -> toInsert -> node1
    private void insertNode(Node toInsert){
        Node node1 = head.next;

        toInsert.next = node1;
        toInsert.prev = head;

        head.next = toInsert;
        node1.prev = toInsert;
    }

    // head -> node1 -> toDelete -> node2
    private void deleteNode(Node toDelete){
        Node node1 = toDelete.prev;
        Node node2 = toDelete.next;

        node1.next = node2;
        node2.prev = node1;
    }
    
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    HashMap<Integer, Node> map = new HashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node current = map.get(key);

            deleteNode(current);
            insertNode(current);

            return current.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node current = map.get(key);

            deleteNode(current);
            map.remove(key);
        }

        if(map.size() == this.capacity){
            Node last = tail.prev;

            deleteNode(last);
            map.remove(last.key);
        }

        Node newNode = new Node(key, value);
        insertNode(newNode);
        map.put(key, newNode);
    }
}

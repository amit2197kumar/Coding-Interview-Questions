/*
Company Tags:  Adobe Amazon Flipkart Goldman Sachs Hike MakeMyTrip Morgan Stanley Ola Cabs OYO Rooms Paytm Samsung
Snapdeal Visa Walmart Yahoo Zoho
Practice Portal:
LeetCode: https://leetcode.com/problems/lru-cache/
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/lru-cache/1
*/

/*
Using HashMap as Cashe is by nature a key-value pair itself
Using doubly Linked-list as:
1. Add head operation take O(1)
3. Delete any node operation take O(1)
*/

class LRUCache {

    //Node Class for doubly Linked-list
    class Node {
        int key;
        int value;

        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //Map to kep the key & Node data (Cache is key-value pair)
    Map<Integer, Node> map;
    int capacity;
    //Dummy head and tail, for easy <add to head> & <delete tail node> operation
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);

        //Created dummy nodes doubly Linked-list
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;

    }

    /*
    For get(), as data(node) been used, its will be Most Recently Used
    So this node need to be on top
    We get the node from map, remove the node from doubly Linked-list (O(1))
    And then add that node as the head of doubly Linked-list (O(1))
    */
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            insertNodeToHead(node);

            return node.value;
        }
        return -1;
    }

    /*
    Put can be used for 2 things:
    1. key alredy present, but value is updated
    2. New key been added in the Cache

    For Case 1 simply get the Node, update its value and make it head. Also delete the old node
    For Case 2 check is capacity
    If capacity is full, delete the (Least Recently Used) node/key, that is last in DLL. Delete that key from Map and then from DLL
    If capacity is not full, simply make new node, add new key(& node) in map, make new node as head
    */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            node.value = value;
            insertNodeToHead(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }

            Node node = new Node(key, value);
            insertNodeToHead(node);
            map.put(key, node);
        }
    }

    //Adding node to top as head
    private void insertNodeToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        head.next = node;
    }

    //Eviction of old data, by deleting the last node(Least Recently Used)
    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
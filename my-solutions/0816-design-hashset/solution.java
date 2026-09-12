class MyHashSet {
    // Define a simple Node class for the linked list
    class Node {
        int key;
        Node next;
        
        Node(int key) {
            this.key = key;
        }
    }
    
    private Node[] buckets;
    // 10,000 is a good bucket size to minimize collisions for 10^4 calls
    private static final int SIZE = 10000; 

    public MyHashSet() {
        buckets = new Node[SIZE];
    }
    
    private int hash(int key) {
        return key % SIZE;
    }
    
    public void add(int key) {
        int h = hash(key);
        Node curr = buckets[h];
        
        if (curr == null) {
            buckets[h] = new Node(key);
            return;
        }
        
        // If the key is at the head
        if (curr.key == key) return;
        
        // Traverse to check for duplicates or find the end
        while (curr.next != null) {
            if (curr.next.key == key) return; // Key already exists
            curr = curr.next;
        }
        
        // Add new node at the end
        curr.next = new Node(key);
    }
    
    public void remove(int key) {
        int h = hash(key);
        Node curr = buckets[h];
        
        if (curr == null) return;
        
        // If the key to remove is at the head of the list
        if (curr.key == key) {
            buckets[h] = curr.next;
            return;
        }
        
        // Traverse to find the node to remove
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next; // Bypass the node to delete it
                return;
            }
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        int h = hash(key);
        Node curr = buckets[h];
        
        // Traverse the linked list at the hashed index
        while (curr != null) {
            if (curr.key == key) return true;
            curr = curr.next;
        }
        
        return false;
    }
}

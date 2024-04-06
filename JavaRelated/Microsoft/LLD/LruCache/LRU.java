package LLD.LruCache;

import java.util.*;

class LRU {
    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap();
    int capacity;

    public LRU(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public static void main(String[] args) {
        // Create an LRUCache with capacity 2
        LRU cache = new LRU(2);

        // Put some key-value pairs
        cache.put(1, 1);
        cache.put(2, 2);

        // Get and print values
        System.out.println(cache.get(1)); // Output: 1
        System.out.println(cache.get(2)); // Output: 2

        // Put another key-value pair, which should evict the least recently used (LRU)
        // item (key 1)
        cache.put(3, 3);

        // Get and print values
        System.out.println(cache.get(1)); // Output: -1 (key 1 is evicted)
        System.out.println(cache.get(2)); // Output: 2
        System.out.println(cache.get(3)); // Output: 3
    }
}

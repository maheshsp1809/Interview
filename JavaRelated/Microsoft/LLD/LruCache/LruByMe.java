package LLD.LruCache;

import java.util.*;

public class LruByMe {
    public static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LruByMe(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }
        if (map.size() == capacity) {
            Node toRemove = tail.prev;
            removeNode(toRemove);
            map.remove(toRemove.key);
        }
        Node newNode = new Node(key, value);
        addToHead(newNode);
        map.put(key, newNode);

    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

    }

    private void addToHead(Node node) {
        Node next = head.next;
        node.prev = head;
        node.next = next;
        head.next = node;
        next.prev = node;

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        System.out.println("Value for key 1: " + cache.get(1)); // Output: 10
        cache.put(4, 40);
        System.out.println("Value for key 2: " + cache.get(2));
        cache.put(5, 50);
        System.out.println("Value for key 2: " + cache.get(3));
        cache.put(6, 60);
        System.out.println("Value for key 2: " + cache.get(3));
        cache.put(7, 70);
        System.out.println("Value for key 2: " + cache.get(3));

        // Output: -1 (2 was evicted)
    }

}

package LLD.LruCache;

import java.util.*;

public class LruByMe {
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LruByMe(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int getValueFortheKey(int key) {
        if (map.containsKey(key)) {
            Node nodeToBeGot = map.get(key);
            removeNode(nodeToBeGot);
            addToHead(nodeToBeGot);
            return nodeToBeGot.value;

        }
        return -1;
    }

    public void putKeyValueToCache(int key, int value) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }
        if (map.size() == capacity) {
            Node toRemove = tail.prev;
            removeNode(toRemove);
            map.remove(toRemove.key);

        }
        Node newNodeToBeAddedToCache = new Node(key, value);
        addToHead(newNodeToBeAddedToCache);
        map.put(key, newNodeToBeAddedToCache);

    }

    public void removeNode(Node nodetoBeRemovedFromCache) {
        Node next = nodetoBeRemovedFromCache.next;
        Node prev = nodetoBeRemovedFromCache.prev;
        prev.next = next;
        next.prev = prev;

    }

    public void addToHead(Node nodeToBeAdded) {
        Node next = head.next;
        next.prev = nodeToBeAdded;
        nodeToBeAdded.next = next;
        head.next = nodeToBeAdded;
        nodeToBeAdded.prev = head;

    }

    public static void main(String[] args) {
        LruByMe cache = new LruByMe(3);
        cache.putKeyValueToCache(1, 10);
        cache.putKeyValueToCache(2, 20);
        cache.putKeyValueToCache(3, 30);
        System.out.println("Get value for key 1:" + cache.getValueFortheKey(1));
        cache.putKeyValueToCache(4, 40);
        cache.putKeyValueToCache(7, 70);
        System.out.println("Value for key 2: " + cache.getValueFortheKey(3));

    }

    public static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;

        }

    }
}

package com.java.lru;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class LRUCache {

    private int cap;
    public Map<Integer, Node> cache;
    private Node oldest;
    private Node latest;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.oldest = new Node(0, 0);
        this.latest = new Node(0, 0);
        this.oldest.next = this.latest;
        this.latest.prev = this.oldest;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = latest.prev;
        Node next = latest;
        prev.next = next.prev = node;
        node.next = next;
        node.prev = prev;
    }

    public void put(int key, int value) {
        this.lock.writeLock().lock();
        try {
            if (cache.containsKey(key)) {
                remove(cache.get(key));
            }

            if (cache.size() == cap) {
                System.out.println("Oldest: " + oldest.key + " " + oldest.next.key);
                Node lru = oldest.next;
                remove(lru);
                cache.remove(lru.key);
                System.out.println("Oldest: " + oldest.key + " " + oldest.next.key);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insert(newNode);
        }
        finally {
            this.lock.writeLock().unlock();
        }
    }

    public  void printLinkedList() {
        Node current = latest;
        while (current != null) {
            System.out.print(current.key + " ");
            current = current.next;
        }
        System.out.println();
    }
}

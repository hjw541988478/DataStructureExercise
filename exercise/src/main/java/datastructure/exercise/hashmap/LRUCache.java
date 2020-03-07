package datastructure.exercise.hashmap;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/lru-cache
 */
public class LRUCache {

    public static class DNode {
        public DNode prev;
        public DNode next;
        public int key;
        public int val;
    }

    public void addNode(DNode node) {
        node.next = this.head.next;
        node.prev = this.head;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DNode node) {
        DNode nextNode = node.next;
        DNode preNode = node.prev;
        nextNode.prev = preNode;
        preNode.next = nextNode;
    }

    public void moveToHead(DNode node) {
        removeNode(node);
        addNode(node);
    }

    public DNode popTail() {
        DNode tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
    }

    //keep the head and tail node of double linked list
    private DNode head, tail;
    private HashMap<Integer, DNode> cache;
    private int capacity;
    private int counter;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.counter = 0;
        this.cache = new HashMap<>();

        this.head = new DNode();
        this.tail = new DNode();
        this.head.prev = null;
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.tail.next = null;
    }

    public int get(int key) {
        DNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DNode node = cache.get(key);
        if (node == null) {
            node = new DNode();
            node.key = key;
            node.val = value;
            addNode(node);
            cache.put(key, node);
            counter++;
            if (counter > capacity) {
                cache.remove(popTail().key);
                counter--;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }
}

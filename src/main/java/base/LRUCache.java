package base;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author weixun
 * @Date 2021-09-28
 */
public class LRUCache {

    private int capacity = 0;
    private int size = 0;

    public static class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node() {}

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node head, tail;
    Map<Integer, Node> nodeMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node == null) {
            return -1;
        }

        // key 存在，访问一次则把节点移到链头
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node newNode = nodeMap.get(key);
        if(null != newNode) {
            // 存在，更新
            newNode.val = value;
            moveToHead(newNode);
        } else {
            // 不存在
            newNode = new Node(key, value);
            if(size >= capacity) {
                // 已满，先移除链尾
                Node tailNode = removeTail();
                // 移除哈希表
                nodeMap.remove(tailNode.key);
                size--;
            }
            // 节点添加到链头
            addToHead(newNode);
            nodeMap.put(key, newNode);
            size++;
        }
    }

    private Node removeTail() {
        Node tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
    }

    private void addToHead(Node node) {
        Node oldHead = head.next;
        oldHead.prev = node;
        node.next = oldHead;

        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}

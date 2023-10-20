/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class LRUCache {

    private int capacity;

    private ListNode head = new ListNode(0, 0);

    private ListNode tail = new ListNode(0, 0);

    private Map<Integer, ListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node != null) {
            moveToTail(node);
            node.value = value;
        } else {
            node = new ListNode(key, value);
            add(node);
        }
    }

    private void moveToTail(ListNode node) {
        remove(node);
        add(node);
    }

    private void add(ListNode node) {
        if (map.size() == capacity) {
            remove(head.next);
        }
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        map.put(node.key, node);
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }

    class ListNode {

        int key;

        int value;

        ListNode prev;

        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end


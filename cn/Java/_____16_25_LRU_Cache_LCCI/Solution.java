// @algorithm @lc id=1000026 lang=java 
// @title lru-cache-lcci
package _____16_25_LRU_Cache_LCCI;
import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private int extraSpace;

    private ListNode<Integer, Integer> dummyHead = new ListNode<>(0, 0);

    private ListNode<Integer, Integer> dummyTail = new ListNode<>(0, 0);

    private Map<Integer, ListNode<Integer, Integer>> hashMap;

    public LRUCache(int capacity) {
        hashMap = new HashMap<>(capacity);
        this.extraSpace = capacity;
        dummyHead.addBehind(dummyTail);
    }

    public int get(int key) {
        ListNode<Integer, Integer> node = hashMap.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        ListNode<Integer, Integer> node = hashMap.get(key);
        if (node != null) {
            moveToHead(node);
            node.val = value;
            return;
        }
        node = new ListNode<>(key, value);
        hashMap.put(key, node);
        dummyHead.addBehind(node);
        extraSpace--;
        removeTail();
    }

    private void removeTail() {
        if (extraSpace < 0) {
            hashMap.remove(dummyTail.prev.remove().key);
            extraSpace++;
        }
    }

    private void moveToHead(ListNode<Integer, Integer> node) {
        dummyHead.addBehind(node.remove());
    }

    private class ListNode<K, V> {

        public K key;

        public V val;

        public ListNode<K, V> prev, next;

        public ListNode(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public void addBehind(ListNode<K, V> node) {
            if (next != null) {
                next.prev = node;
            }
            node.next = next;
            node.prev = this;
            next = node;
        }

        public ListNode<K, V> remove() {
            prev.next = next;
            next.prev = prev;
            return this;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
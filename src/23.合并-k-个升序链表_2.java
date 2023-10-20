/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并 K 个升序链表
 */

import java.util.PriorityQueue;

import utils.ListNode;

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ComparableListNode> priorityQueue = new PriorityQueue<>(lists.length);
        ListNode head = new ListNode();
        ListNode p = head;
        for (ListNode list: lists) {
            if (list != null) {
                priorityQueue.offer(new ComparableListNode(list));
            }
        }
        while (!priorityQueue.isEmpty()) {
            p.next = priorityQueue.poll().node;
            p = p.next;
            if (p.next != null) {
                priorityQueue.offer(new ComparableListNode(p.next));
            }
        }
        return head.next;
    }
    class ComparableListNode implements Comparable<ComparableListNode> {
        public ListNode node;
        public ComparableListNode(ListNode node) {
            this.node = node;
        }
        @Override
        public int compareTo(ComparableListNode o) {
            return this.node.val < o.node.val ? -1 : 1;
        }
    }
}
// @lc code=end


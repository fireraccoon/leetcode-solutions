/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

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
    public ListNode sortList(ListNode head) {
        int size = sizeOf(head);
        ListNode dummy = new ListNode(0, head);
        ListNode prev, pointer, e1, e2, l2;
        for (int i = 1; i < size; i *= 2) {
            prev = dummy;
            pointer = dummy.next;
            while (pointer != null) {
                e1 = getNode(pointer, i);
                if (e1.next == null) {
                    break;
                }
                e2 = getNode(e1.next, i);
                l2 = e1.next;
                e1.next = null;
                e1 = e2.next;
                e2.next = null;
                prev.next = mergeSorted(pointer, l2);
                prev = getNode(prev.next, i * 2);
                pointer = e1;
            }
            if (pointer != null) {
                prev.next = pointer;
            }
        }
        return dummy.next;
    }
    ListNode getNode(ListNode head, int size) {
        while (--size > 0 && head.next != null) {
            head = head.next;
        }
        return head;
    }
    ListNode mergeSorted(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode pointer = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        pointer.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
    int sizeOf(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(), tail, p1 = list1, p2 = list2;
        tail = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = new ListNode(p1.val, null);
                p1 = p1.next;
            } else {
                tail.next = new ListNode(p2.val, null);
                p2 = p2.next;
            }
            tail = tail.next;
        }
        if (p1 != null) {
            tail.next = p1;
        } else {
            tail.next = p2;
        }
        return head.next;
    }
}
// @lc code=end


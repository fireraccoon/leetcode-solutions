/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, p_n = null;
        int length = 0;
        while (p != null) {
            length++;
            if (length == n + 1) {
                p_n = head;
            } else if (length > n + 1) {
                p_n = p_n.next;
            }
            p = p.next;
        }
        if (length == n) {
            return head.next;
        } else {
            p_n.next = p_n.next.next;
            return head;
        }
    }
}
// @lc code=end


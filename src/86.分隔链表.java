/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = new ListNode(0, head);
        ListNode gap = ans, next;
        while (gap.next != null && gap.next.val < x) {
            gap = gap.next;
        }
        next = gap;
        while (next.next != null) {
            if (next.next.val < x) {
                ListNode tmp = next.next.next;
                next.next.next = gap.next;
                gap.next = next.next;
                next.next = tmp;
                gap = gap.next;
            } else {
                next = next.next;
            }
        }
        return ans.next;
    }
}
// @lc code=end


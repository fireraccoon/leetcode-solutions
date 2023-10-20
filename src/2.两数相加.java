/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l = new ListNode(0, null);
        ListNode lt = l;
        while (true) {
            if (l1 != null) {
                lt.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                lt.val += l2.val;
                l2 = l2.next;
            }
            carry = lt.val >= 10 ? 1 : 0;
            lt.val -= lt.val >= 10 ? 10 : 0;
            if (l1 == null && l2 == null) {
                break;
            } else {
                lt = lt.next = new ListNode(carry, null);
            }
        }
        lt.next = carry != 0 ? new ListNode(carry, null) : null;
        return l;
    }
}
// @lc code=end


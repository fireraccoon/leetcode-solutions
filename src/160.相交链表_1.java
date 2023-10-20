/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

import utils.ListNode;

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tailA = headA;
        while (tailA.next != null) {
            tailA = tailA.next;
        }
        tailA.next = headB;
        ListNode slow = headA, fast = headA;
        for (boolean slowAdded = false; fast != null; slowAdded = !slowAdded) {
            fast = fast.next;
            if (slowAdded) {
                slow = slow.next;
                if (slow == fast) {
                    break;
                }
            }
        }
        if (fast != null) {
            fast = headA;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        tailA.next = null;
        return fast;
    }
}
// @lc code=end


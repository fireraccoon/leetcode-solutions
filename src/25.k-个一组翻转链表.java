/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head, hair = head, next;
        while (tail != null) {
            next = tail;
            for (int i = 0; i < k - 1; i++) {
                if (tail.next == null) {
                    return head;
                }
                tail = tail.next;
            }
            if (next == head) {
                head = reverseList(next, tail.next);
            } else {
                hair.next = reverseList(next, tail.next);
            }
            hair = next;
            tail = next.next;
        }
        return head;
    }
    ListNode reverseList(ListNode head, ListNode tail) {
        ListNode left = head, right = head.next, next;
        while (right != tail) {
            next = right.next;
            right.next = left;
            left = right;
            right = next;
        }
        head.next = tail;
        return left;
    }
}
// @lc code=end


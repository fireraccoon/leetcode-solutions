/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        k %= length;
        if (k == 0) {
            return head;
        }
        ListNode cursor = head;
        for (int i = 0; i < length - k - 1; i++) {
            cursor = cursor.next;
        }
        ListNode ans = cursor.next;
        cursor.next = null;
        tail.next = head;
        return ans;
    }
}
// @lc code=end


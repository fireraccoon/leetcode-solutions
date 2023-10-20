/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    private ListNode ans;
    public ListNode reverseList(ListNode head) {
        reverseSubList(head);
        return ans;
    }
    ListNode reverseSubList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode subList = reverseSubList(head.next);
        if (subList != null) {
            subList.next = head;
        } else {
            ans = head;
        }
        head.next = null;
        return head;
    }
}
// @lc code=end


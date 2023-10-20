/*
 * @lc app=leetcode.cn id=876 lang=java
 *
 * [876] 链表的中间结点
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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        for (boolean isSlowMoved = false; fast != null; isSlowMoved = !isSlowMoved) {
            if (isSlowMoved) {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return slow;
    }
}
// @lc code=end


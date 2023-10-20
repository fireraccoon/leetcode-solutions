/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        ListNode pointer = dummyHead;
        while (head != null) {
            if (head.val != val) {
                pointer.next = head;
                pointer = pointer.next;
            }
            head = head.next;
        }
        pointer.next = null;
        return dummyHead.next;
    }
}
// @lc code=end


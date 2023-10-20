/*
 * @lc app=leetcode.cn id=2095 lang=java
 *
 * [2095] 删除链表的中间节点
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
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slowPrev = dummy, fast = head;
        for (boolean isSlowAdded = false; fast != null; isSlowAdded = !isSlowAdded) {
            if (isSlowAdded) {
                slowPrev = slowPrev.next;
            }
            fast = fast.next;
        }
        slowPrev.next = slowPrev.next.next;
        return dummy.next;
    }
}
// @lc code=end


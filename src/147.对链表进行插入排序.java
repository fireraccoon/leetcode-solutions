/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        ListNode ans = new ListNode(0, head);
        ListNode right = head.next, left;
        head.next = null;
        while (right != null) {
            left = ans;
            while (left.next != null && left.next.val < right.val) {
                left = left.next;
            }
            ListNode nextLeft = left.next;
            left.next = right;
            right = right.next;
            left.next.next = nextLeft;
        }
        return ans.next;
    }
}
// @lc code=end


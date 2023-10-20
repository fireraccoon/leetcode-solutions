/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pointer = head, next = head.next;
        head = new ListNode(0, null);
        ListNode ansPointer = head;
        boolean skip = false;
        while (next != null) {
            if (pointer.val == next.val) {
                next = next.next;
                skip = true;
            } else {
                if (!skip) {
                    ansPointer.next = pointer;
                    ansPointer = ansPointer.next;
                }
                pointer = next;
                next = pointer.next;
                skip = false;
            }
        }
        if (!skip) {
            ansPointer.next = pointer;
            ansPointer = ansPointer.next;
        }
        ansPointer.next = null;
        return head.next;
    }
}
// @lc code=end


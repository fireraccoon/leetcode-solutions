/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode ans = new ListNode(0, head);
        ListNode pointer, nextPointer, nextNextPointer;
        head = ans;
        for (; left > 1; left--, right--) {
            head = head.next;
        }
        pointer = head.next;
        nextPointer = pointer.next;
        for (int i = 1; i < right; i++) {
            nextNextPointer = nextPointer.next;
            nextPointer.next = pointer;
            pointer = nextPointer;
            nextPointer = nextNextPointer;
        }
        nextNextPointer = head.next;
        head.next = pointer;
        nextNextPointer.next = nextPointer;
        return ans.next;
    }
}
// @lc code=end


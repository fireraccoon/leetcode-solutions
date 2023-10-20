/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    ListNode frontPointer;
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recurseBackToCheck(head);
    }
    boolean recurseBackToCheck(ListNode node) {
        if (node == null) {
            return true;
        }
        if (!recurseBackToCheck(node.next) || node.val != frontPointer.val) {
            return false;
        }
        frontPointer = frontPointer.next;
        return true;
    }
}
// @lc code=end


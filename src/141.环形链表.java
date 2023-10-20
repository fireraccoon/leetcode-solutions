/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

import utils.ListNode;

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head, fastPointer = head;
        for (boolean slowPointerAdded = false; fastPointer != null;) {
            fastPointer = fastPointer.next;
            if (slowPointerAdded) {
                slowPointer = slowPointer.next;
                if (slowPointer == fastPointer) {
                    return true;
                }
            }
            slowPointerAdded = !slowPointerAdded;
        }
        return false;
    }
}
// @lc code=end


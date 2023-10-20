/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
    public ListNode detectCycle(ListNode head) {
        ListNode slowPointer = head, fastPointer = head;
        for (boolean slowPointerAdded = false; fastPointer != null;) {
            fastPointer = fastPointer.next;
            if (slowPointerAdded) {
                slowPointer = slowPointer.next;
                if (slowPointer == fastPointer) {
                    break;
                }
            }
            slowPointerAdded = !slowPointerAdded;
        }
        if (fastPointer == null) {
            return null;
        }
        fastPointer = head;
        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return fastPointer;
    }
}
// @lc code=end


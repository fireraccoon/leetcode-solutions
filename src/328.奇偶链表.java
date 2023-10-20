/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOddHead = new ListNode(), dummyEvenHead = new ListNode();
        ListNode pointer = head, oddPointer = dummyOddHead, evenPointer = dummyEvenHead;
        for (boolean isOdd = true; pointer != null; isOdd = !isOdd) {
            if (isOdd) {
                oddPointer.next = pointer;
                oddPointer = oddPointer.next;
            } else {
                evenPointer.next = pointer;
                evenPointer = evenPointer.next;
            }
            pointer = pointer.next;
        }
        oddPointer.next = dummyEvenHead.next;
        evenPointer.next = null;
        return dummyOddHead.next;
    }
}
// @lc code=end


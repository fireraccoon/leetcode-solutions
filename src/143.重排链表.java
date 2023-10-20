/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        ListNode middle = getMiddle(head);
        ListNode middleReverse = reverse(middle);
        combine(head, middle, middleReverse);
    }
    ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    ListNode reverse(ListNode head) {
        ListNode lastNode = null, nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = lastNode;
            lastNode = head;
            head = nextNode;
        }
        return lastNode;
    }
    void combine(ListNode head, ListNode middle, ListNode middleReverse) {
        ListNode nextNode;
        while (head.next != middle) {
            nextNode = middleReverse.next;
            middleReverse.next = head.next;
            head.next = middleReverse;
            head = middleReverse.next;
            middleReverse = nextNode;
        }
        head.next = middleReverse;
    }
}
// @lc code=end


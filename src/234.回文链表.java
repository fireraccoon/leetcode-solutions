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
    public boolean isPalindrome(ListNode head) {
        ListNode median = getMedian(head);
        ListNode reversed = reverse(median);
        boolean ans = prefixEquals(head, reversed);
        reverse(reversed);
        return ans;
    }
    boolean prefixEquals(ListNode a, ListNode b) {
        while (a != null && b != null) {
            if (a.val != b.val) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return true;
    }
    ListNode getMedian(ListNode head) {
        ListNode fast = head, slow = head;
        for (boolean isSlowAdded = false; fast.next != null; isSlowAdded = !isSlowAdded) {
            fast = fast.next;
            if (isSlowAdded) {
                slow = slow.next;
            }
        }
        return slow;
    }
    ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode pointer = head;
        while (pointer != null) {
            ListNode tmp = pointer.next;
            pointer.next = dummy.next;
            dummy.next = pointer;
            pointer = tmp;
        }
        return dummy.next;
    }
}
// @lc code=end


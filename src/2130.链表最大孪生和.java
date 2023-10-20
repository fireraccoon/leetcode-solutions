/*
 * @lc app=leetcode.cn id=2130 lang=java
 *
 * [2130] 链表最大孪生和
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
    public int pairSum(ListNode head) {
        ListNode median = getMedian(head);
        ListNode reversed = reverse(median);
        ListNode p1 = head, p2 = reversed;
        int ans = Integer.MIN_VALUE;
        while (p1 != median) {
            ans = Math.max(ans, p1.val + p2.val);
            p1 = p1.next;
            p2 = p2.next;
        }
        reverse(reversed);
        return ans;
    }
    ListNode getMedian(ListNode head) {
        ListNode slow = head, fast = head;
        for (boolean isSlowAdded = true; fast != null; isSlowAdded = !isSlowAdded) {
            if (isSlowAdded) {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return slow;
    }
    ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}
// @lc code=end


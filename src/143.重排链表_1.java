/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

import java.util.ArrayList;
import java.util.List;

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
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            ListNode lNode = list.get(left), rNode = list.get(right);
            rNode.next = lNode.next;
            lNode.next = rNode;
            left++;
            right--;
        }
        list.get(left).next = null;
    }
}
// @lc code=end


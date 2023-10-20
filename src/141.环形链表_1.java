/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

import java.util.HashSet;
import java.util.Set;

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
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
// @lc code=end


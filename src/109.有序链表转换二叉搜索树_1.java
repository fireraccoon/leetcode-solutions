/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */

import utils.*;

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildSubtrees(head, null);
    }
    TreeNode buildSubtrees(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode middle = getMedian(left, right);
        TreeNode root = new TreeNode(middle.val);
        root.left = buildSubtrees(left, middle);
        root.right = buildSubtrees(middle.next, right);
        return root;
    }
    ListNode getMedian(ListNode left, ListNode right) {
        ListNode pointer = left, median = left;
        while (pointer != right && pointer.next != right) {
            pointer = pointer.next;
            pointer = pointer.next;
            median = median.next;
        }
        return median;
    }
}
// @lc code=end


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
    ListNode pointer;
    public TreeNode sortedListToBST(ListNode head) {
        pointer = head;
        return buildSubtrees(0, sizeOf(head) - 1);
    }
    TreeNode buildSubtrees(int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode();
        int middle = (left + right) / 2;
        root.left = buildSubtrees(left, middle - 1);
        root.val = pointer.val;
        pointer = pointer.next;
        root.right = buildSubtrees(middle + 1, right);
        return root;
    }
    int sizeOf(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}
// @lc code=end


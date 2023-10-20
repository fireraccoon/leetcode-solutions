/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 */

import utils.TreeNode;

// @lc code=start
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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE, root, null);
        TreeNode parent = dummy, pointer = root;
        while (pointer != null && pointer.val != key) {
            parent = pointer;
            if (pointer.val > key) {
                pointer = pointer.left;
            } else {
                pointer = pointer.right;
            }
        }
        if (pointer == null) {
            return root;
        }
        if (pointer.right == null) {
            if (parent.val > pointer.val) {
                parent.left = pointer.left;
            } else {
                parent.right = pointer.left;
            }
        } else {
            TreeNode right = pointer.right, rightParent = null;
            while (right.left != null) {
                rightParent = right;
                right = right.left;
            }
            if (parent.val > pointer.val) {
                parent.left = right;
            } else {
                parent.right = right;
            }
            right.left = pointer.left;
            if (rightParent != null) {
                rightParent.left = right.right;
                right.right = pointer.right;
            }
        }
        return dummy.left;
    }
}
// @lc code=end


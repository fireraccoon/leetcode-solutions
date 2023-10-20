/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    public void recoverTree(TreeNode root) {
        boolean leftWasNull = false;
        TreeNode a = null, b = null;
        TreeNode predecessor, lastNode = new TreeNode(Integer.MIN_VALUE);
        while (root != null) {
            if (root.left == null || leftWasNull) {
                if (root.val < lastNode.val) {
                    if (a == null) {
                        a = lastNode;
                    }
                    b = root;
                }
                lastNode = root;
                root = root.right;
                leftWasNull = false;
            } else {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == root) {
                    predecessor.right = null;
                    leftWasNull = true;
                } else {
                    predecessor.right = root;
                    root = root.left;
                }
            }
        }
        swap(a, b);
    }
    void swap(TreeNode a, TreeNode b) {
        int num = a.val;
        a.val = b.val;
        b.val = num;
    }
}
// @lc code=end


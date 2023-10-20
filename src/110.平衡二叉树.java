/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root, 0);
        return isBalanced;
    }
    int dfs(TreeNode root, int deepth) {
        if (root == null || !isBalanced) {
            return deepth;
        }
        int leftDeepth = dfs(root.left, deepth + 1);
        int rightDeepth = dfs(root.right, deepth + 1);
        if (Math.abs(leftDeepth - rightDeepth) > 1) {
            isBalanced = false;
        }
        return Math.max(leftDeepth, rightDeepth);
    }
}
// @lc code=end


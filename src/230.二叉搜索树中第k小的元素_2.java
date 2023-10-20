/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }
    int dfs(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftAns = dfs(root.left);
        if (leftAns != Integer.MIN_VALUE) {
            return leftAns;
        }
        return --k < 1 ? root.val : dfs(root.right);
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    int minDeepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return minDeepth;
    }
    void dfs(TreeNode root, int deepth) {
        if (root.left == null && root.right == null) {
            minDeepth = Math.min(minDeepth, deepth);
        } else {
            if (root.left != null && deepth < minDeepth) {
                dfs(root.left, deepth + 1);
            }
            if (root.right != null && deepth < minDeepth) {
                dfs(root.right, deepth + 1);
            }
        }
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=1372 lang=java
 *
 * [1372] 二叉树中的最长交错路径
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
    private int ans = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return ans;
    }
    void dfs(TreeNode root, boolean isLeftChild, int longestZigZag) {
        if (root == null) {
            return;
        }
        ans = Math.max(ans, longestZigZag);
        if (isLeftChild) {
            dfs(root.left, true, 1);
            dfs(root.right, false, longestZigZag + 1);
        } else {
            dfs(root.left, true, longestZigZag + 1);
            dfs(root.right, false, 1);
        }
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    private int pre = Integer.MIN_VALUE;
    public int getMinimumDifference(TreeNode root) {
        return inorder(root);
    }
    int inorder(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        if (root.left != null) {
            ans = inorder(root.left);
        }
        if (pre != Integer.MIN_VALUE) {
            ans = Math.min(root.val - pre, ans);
        }
        pre = root.val;
        if (root.right != null) {
            ans = Math.min(ans, inorder(root.right));
        }
        return ans;
    }
}
// @lc code=end


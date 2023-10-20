/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    public int maxPathSum(TreeNode root) {
        int leftPathSum = Integer.MIN_VALUE;
        int rightPathSum = Integer.MIN_VALUE;
        int subtreeCombineVal = 0;
        int ans = root.val;
        if (root.left != null) {
            leftPathSum = maxPathSum(root.left);
            subtreeCombineVal = Math.max(subtreeCombineVal, root.left.val);
            ans += Math.max(0, root.left.val);
        }
        if (root.right != null) {
            rightPathSum = maxPathSum(root.right);
            subtreeCombineVal = Math.max(subtreeCombineVal, root.right.val);
            ans += Math.max(0, root.right.val);
        }
        ans = Math.max(ans, leftPathSum);
        ans = Math.max(ans, rightPathSum);
        root.val += subtreeCombineVal;
        return ans;
    }
}
// @lc code=end


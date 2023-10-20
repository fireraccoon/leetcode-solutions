/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

import utils.TreeNode;

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
    boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (ans != null || root == null) {
            return false;
        }
        boolean leftFounded = dfs(root.left, p, q);
        boolean rightFounded = dfs(root.right, p, q);
        if (leftFounded && rightFounded || (root == p || root == q) && (leftFounded || rightFounded)) {
            ans = root;
        }
        return leftFounded || rightFounded || root == p || root == q;
    }
}
// @lc code=end


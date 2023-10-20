/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode parent = root;
        while (p != parent && q != parent && !(p.val < parent.val ^ q.val < parent.val)) {
            if (p.val < parent.val) {
                parent = parent.left;
            } else {
                parent = parent.right;
            }
        }
        return parent;
    }
}
// @lc code=end


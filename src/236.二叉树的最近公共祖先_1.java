/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

import java.util.ArrayList;
import java.util.List;

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
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        dfs(path1, root, p);
        dfs(path2, root, q);
        TreeNode ans = root;
        int prefixLength = Math.min(path1.size(), path2.size());
        for (int i = 1; i < prefixLength && path1.get(i) == path2.get(i); i++) {
            ans = path1.get(i);
        }
        return ans;
    }
    boolean dfs(List<TreeNode> path, TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root == target) {
            return true;
        }
        boolean ans = dfs(path, root.left, target) || dfs(path, root.right, target);
        if (!ans) {
            path.remove(path.size() - 1);
        }
        return ans;
    }
}
// @lc code=end


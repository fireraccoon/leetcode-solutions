/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        Map<Integer, TreeNode> parents = new HashMap<>();
        Set<Integer> path = new HashSet<>();
        dfs(parents, root);
        while (p != null) {
            path.add(p.val);
            p = parents.get(p.val);
        }
        while (q != null) {
            if (path.contains(q.val)) {
                return q;
            }
            q = parents.get(q.val);
        }
        return null;
    }
    void dfs(Map<Integer, TreeNode> parents, TreeNode root) {
        if (root.left != null) {
            parents.put(root.left.val, root);
            dfs(parents, root.left);
        }
        if (root.right != null) {
            parents.put(root.right.val, root);
            dfs(parents, root.right);
        }
    }
}
// @lc code=end


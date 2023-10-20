/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    int maxDepth = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root, 1);
        return ans;
    }
    void dfs(List<Integer> ans, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > maxDepth) {
            ans.add(root.val);
            maxDepth = depth;
        }
        depth++;
        dfs(ans, root.right, depth);
        dfs(ans, root.left, depth);
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=1448 lang=java
 *
 * [1448] 统计二叉树中好节点的数目
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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    int dfs(TreeNode root, int pathMax) {
        int counter = 0;
        if (root.val >= pathMax) {
            counter++;
            pathMax = root.val;
        }
        if (root.left != null) {
            counter += dfs(root.left, pathMax);
        }
        if (root.right != null) {
            counter += dfs(root.right, pathMax);
        }
        return counter;
    }
}
// @lc code=end


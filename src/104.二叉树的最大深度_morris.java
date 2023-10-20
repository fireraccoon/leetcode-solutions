/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        boolean leftWasNull = false;
        int deepth = 1, maxDeepth = 0;
        TreeNode pointer, predecessor;
        while (root != null) {
            if (root.left == null || leftWasNull) {
                maxDeepth = Math.max(deepth, maxDeepth);
                root = root.right;
                deepth++;
                leftWasNull = false;
            } else {
                int predecessorDeepth = 2;
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessorDeepth++;
                    predecessor = predecessor.right;
                }
                if (predecessor.right == root) {
                    predecessor.right = null;
                    leftWasNull = true;
                    deepth -= predecessorDeepth;
                } else {
                    predecessor.right = root;
                    pointer = root.left;
                    root = pointer;
                    deepth++;
                }
            }
        }
        return maxDeepth;
    }
}
// @lc code=end


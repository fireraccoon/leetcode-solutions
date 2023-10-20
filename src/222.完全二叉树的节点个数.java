/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = getLevel(root);
        int left = 1 << level - 1;
        int right = (1 << level) - 1;
        while (left < right) {
            int middle = left + right + 1 >> 1;
            if (exists(root, middle, level)) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }
    boolean exists(TreeNode root, int index, int level) {
        level -= 2;
        while (root != null && level >= 0) {
            if ((index >>> level & 1) == 0) {
                root = root.left;
            } else {
                root = root.right;
            }
            level--;
        }
        return root != null;
    }
    int getLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> dp = new ArrayList<>();
        dp.add(new TreeNode(1));
        for (int i = 2, length; i <= n; i++) {
            length = dp.size();
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < i; k++) {
                    TreeNode pointer = cloneTree(dp.get(j));
                    dp.add(pointer);
                    for (int l = 0; l < k && pointer.right != null; l++) {
                        pointer = pointer.right;
                    }
                    pointer.right = new TreeNode(i, pointer.right, null);
                    if (pointer.right.left == null) {
                        break;
                    }
                }
                dp.set(j, new TreeNode(i, dp.get(j), null));
            }
        }
        return dp;
    }
    TreeNode cloneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return new TreeNode(root.val, cloneTree(root.left), cloneTree(root.right));
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode pointer = root, lastRight = null, predecessor;
        while (pointer != null) {
            ans.add(pointer.val);
            predecessor = pointer;
            while (predecessor.right != null) {
                predecessor = predecessor.right;
            }
            if (predecessor != pointer) {
                predecessor.right = lastRight;
                lastRight = pointer.right;
            }
            if (pointer.left != null) {
                pointer = pointer.left;
            } else {
                pointer = lastRight;
                lastRight = null;
            }
        }
        return ans;
    }
}
// @lc code=end


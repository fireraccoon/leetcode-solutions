/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode pointer = root, predecessor;
        while (pointer != null) {
            if (pointer.left != null) {
                predecessor = pointer.left;
                while (predecessor.right != null && predecessor.right != pointer) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == pointer) {
                    predecessor.right = null;
                    ans.add(pointer.val);
                    pointer = pointer.right;
                } else {
                    predecessor.right = pointer;
                    pointer = pointer.left;
                }
            } else {
                ans.add(pointer.val);
                pointer = pointer.right;
            }
        }
        return ans;
    }
}
// @lc code=end


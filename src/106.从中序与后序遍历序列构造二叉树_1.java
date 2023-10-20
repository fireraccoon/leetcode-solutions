/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

import java.util.Deque;
import java.util.LinkedList;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        for (int i = postorder.length - 2, j = inorder.length - 1; i >= 0; i--) {
            TreeNode node = stack.peek();
            if (node.val != inorder[j]) {
                node.right = new TreeNode(postorder[i]);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    node = stack.pop();
                    j--;
                }
                node.left = new TreeNode(postorder[i]);
                stack.push(node.left);
            }
        }
        return root;
    }
}
// @lc code=end


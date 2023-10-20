/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        stack.push(root);
        TreeNode pointer = root;
        while (!stack.isEmpty()) {
            while (pointer.left != null) {
                pointer = pointer.left;
                stack.push(pointer);
            }
            pointer = stack.peek();
            root = null;
            while (!stack.isEmpty() && (pointer.right == root || pointer.right == null)) {
                root = stack.pop();
                ans.add(root.val);
                pointer = stack.peek();
            }
            if (pointer != null) {
                pointer = pointer.right;
                stack.push(pointer);
            }
        }
        return ans;
    }
}
// @lc code=end


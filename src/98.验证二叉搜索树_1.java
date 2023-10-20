/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public boolean isValidBST(TreeNode root) {
        long num = Long.MIN_VALUE;
        TreeNode pointer;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if (stack.peek() != null) {
                stack.push(stack.peek().left);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    pointer = stack.pop();
                    if (pointer.val <= num) {
                        return false;
                    }
                    num = pointer.val;
                    stack.push(pointer.right);
                }
            }
        }
        return true;
    }
}
// @lc code=end


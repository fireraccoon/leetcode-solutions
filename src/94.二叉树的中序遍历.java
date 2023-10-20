/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pointer;
        stack.push(root);
        while (!stack.isEmpty()) {
            if (stack.peek() != null) {
                stack.push(stack.peek().left);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    pointer = stack.pop();
                    ans.add(pointer.val);
                    stack.push(pointer.right);
                }
            }
        }
        return ans;
    }
}
// @lc code=end


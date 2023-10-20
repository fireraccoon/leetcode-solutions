/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    public int kthSmallest(TreeNode root, int k) {
        int ans = 0;
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
                    if (--k < 1) {
                        ans = pointer.val;
                        break;
                    }
                    stack.push(pointer.right);
                }
            }
        }
        return ans;
    }
}
// @lc code=end


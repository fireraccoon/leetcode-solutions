/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int maxDepth = 0, depth = 1;
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        nodeStack.push(root);
        depthStack.push(depth);
        while (!nodeStack.isEmpty()) {
            if (depth > maxDepth) {
                maxDepth = depth;
                ans.add(root.val);
            }
            depth++;
            if (root.left != null) {
                nodeStack.push(root.left);
                depthStack.push(depth);
            }
            if (root.right != null) {
                root = root.right;
                nodeStack.push(root);
                depthStack.push(depth);
            } else {
                root = nodeStack.pop();
                depth = depthStack.pop();
            }
        }
        return ans;
    }
}
// @lc code=end


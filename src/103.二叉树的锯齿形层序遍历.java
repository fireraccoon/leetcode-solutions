/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> nodes = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                if ((ans.size() & 1) == 0) {
                    root = queue.pollFirst();
                    if (root.left != null) {
                        queue.offerLast(root.left);
                    }
                    if (root.right != null) {
                        queue.offerLast(root.right);
                    }
                } else {
                    root = queue.pollLast();
                    if (root.right != null) {
                        queue.offerFirst(root.right);
                    }
                    if (root.left != null) {
                        queue.offerFirst(root.left);
                    }
                }
                nodes.add(root.val);
            }
            ans.add(nodes);
        }
        return ans;
    }
}
// @lc code=end


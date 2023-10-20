/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> nodes = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode pointer = queue.poll();
                if (pointer.left != null) {
                    queue.offer(pointer.left);
                }
                if (pointer.right != null) {
                    queue.offer(pointer.right);
                }
                nodes.add(pointer.val);
            }
            ans.add(nodes);
        }
        return ans;
    }
}
// @lc code=end


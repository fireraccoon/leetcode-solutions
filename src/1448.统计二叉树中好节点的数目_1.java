/*
 * @lc app=leetcode.cn id=1448 lang=java
 *
 * [1448] 统计二叉树中好节点的数目
 */

import java.util.LinkedList;
import java.util.Queue;

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
    public int goodNodes(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> maxQueue = new LinkedList<>();
        queue.offer(root);
        maxQueue.offer(Integer.MIN_VALUE);
        while (!queue.isEmpty()) {
            TreeNode pointer = queue.poll();
            int maxVal = maxQueue.poll();
            if (pointer.val >= maxVal) {
                ans++;
                maxVal = pointer.val;
            }
            if (pointer.left != null) {
                queue.offer(pointer.left);
                maxQueue.offer(maxVal);
            }
            if (pointer.right != null) {
                queue.offer(pointer.right);
                maxQueue.offer(maxVal);
            }
        }
        return ans;
    }
}
// @lc code=end


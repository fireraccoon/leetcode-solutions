/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
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
    public int sumNumbers(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queue.offer(root);
        queueSum.offer(0);
        while (!queue.isEmpty()) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                int sum = queueSum.poll() * 10 + node.val;
                if (node.left == null && node.right == null) {
                    ans += sum;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    queueSum.offer(sum);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    queueSum.offer(sum);
                }
            }
        }
        return ans;
    }
}
// @lc code=end


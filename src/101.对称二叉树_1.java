/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        return bfs(root.left, root.right);
    }
    boolean bfs(TreeNode left, TreeNode right) {
        Queue<TreeNode> lQueue = new LinkedList<>();
        Queue<TreeNode> rQueue = new LinkedList<>();
        lQueue.offer(left);
        rQueue.offer(right);
        while (!lQueue.isEmpty() && !rQueue.isEmpty()) {
            left = lQueue.poll();
            right = rQueue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            lQueue.offer(left.left);
            lQueue.offer(left.right);
            rQueue.offer(right.right);
            rQueue.offer(right.left);
        }
        return lQueue.isEmpty() && rQueue.isEmpty();
    }
}
// @lc code=end


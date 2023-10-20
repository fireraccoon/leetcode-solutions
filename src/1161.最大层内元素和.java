/*
 * @lc app=leetcode.cn id=1161 lang=java
 *
 * [1161] 最大层内元素和
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
    public int maxLevelSum(TreeNode root) {
        int level = 0, maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; !queue.isEmpty(); i++) {
            int sum = 0;
            for (int j = queue.size(); j > 0; j--) {
                TreeNode pointer = queue.poll();
                sum += pointer.val;
                if (pointer.left != null) {
                    queue.offer(pointer.left);
                }
                if (pointer.right != null) {
                    queue.offer(pointer.right);
                }
            }
            if (sum > maxSum) {
                level = i;
                maxSum = sum;
            }
        }
        return level;
    }
}
// @lc code=end


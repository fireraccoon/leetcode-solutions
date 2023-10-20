/*
 * @lc app=leetcode.cn id=1372 lang=java
 *
 * [1372] 二叉树中的最长交错路径
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
    public int longestZigZag(TreeNode root) {
        int ans = 0;
        Map<TreeNode, Integer> lChildLongestZigZag = new HashMap<>();
        Map<TreeNode, Integer> rChildLongestZigZag = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> parentQueue = new LinkedList<>();

        parentQueue.offer(root);
        queue.offer(root.left);
        lChildLongestZigZag.put(root.left, 1);
        parentQueue.offer(root);
        queue.offer(root.right);
        rChildLongestZigZag.put(root.right, 1);
        while (!queue.isEmpty()) {
            TreeNode parent = parentQueue.poll(), pointer = queue.poll();
            if (pointer == null) {
                continue;
            }

            if (parent.left == pointer) {
                int length = lChildLongestZigZag.get(pointer);
                ans = Math.max(ans, length);
                lChildLongestZigZag.put(pointer.left, 1);
                rChildLongestZigZag.put(pointer.right, length + 1);
            } else {
                int length = rChildLongestZigZag.get(pointer);
                ans = Math.max(ans, length);
                lChildLongestZigZag.put(pointer.left, length + 1);
                rChildLongestZigZag.put(pointer.right, 1);
            }

            parentQueue.offer(pointer);
            queue.offer(pointer.left);
            parentQueue.offer(pointer);
            queue.offer(pointer.right);
        }
        return ans;
    }
}
// @lc code=end


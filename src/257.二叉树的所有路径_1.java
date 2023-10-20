/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 */

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<StringBuilder> paths = new ArrayDeque<>();
        queue.offer(root);
        paths.offer(new StringBuilder());
        while (!queue.isEmpty()) {
            TreeNode pointer = queue.poll();
            StringBuilder path = paths.poll().append(pointer.val);
            if (pointer.left == null && pointer.right == null) {
                ans.add(path.toString());
            } else {
                StringBuilder sb = new StringBuilder(path.append("->"));
                if (pointer.left != null) {
                    queue.offer(pointer.left);
                    paths.offer(sb);
                }
                if (pointer.right != null) {
                    queue.offer(pointer.right);
                    paths.offer(path);
                }
            }
        }
        return ans;
    }
}
// @lc code=end


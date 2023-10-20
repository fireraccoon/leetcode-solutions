/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 */

import utils.TreeNode;

import java.util.ArrayList;
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(ans, new StringBuilder(), root);
        return ans;
    }
    void dfs(List<String> ans, StringBuilder node, TreeNode root) {
        int size = node.length();
        node.append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(node.toString());
        } else {
            node.append("->");
            if (root.left != null) {
                dfs(ans, node, root.left);
            }
            if (root.right != null) {
                dfs(ans, node, root.right);
            }
        }
        node.delete(size, node.length());
    }
}
// @lc code=end


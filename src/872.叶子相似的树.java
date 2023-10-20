/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
 */

import java.util.ArrayList;
import java.util.List;

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(leaves1, root1);
        dfs(leaves2, root2);
        return leaves1.equals(leaves2);
    }
    void dfs(List<Integer> leaves, TreeNode root) {
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        if (root.left != null) {
            dfs(leaves, root.left);
        }
        if (root.right != null) {
            dfs(leaves, root.right);
        }
    }
}
// @lc code=end


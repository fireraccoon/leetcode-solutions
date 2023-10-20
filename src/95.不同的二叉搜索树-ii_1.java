/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 */

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
    List<TreeNode> dfs(int left, int right) {
        if (left > right) {
            return new ArrayList<>() {{
                add(null);
            }};
        }
        List<TreeNode> trees = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftSubtrees = dfs(left, i - 1);
            List<TreeNode> rightSubtrees = dfs(i + 1, right);
            for (TreeNode leftSubtree : leftSubtrees) {
                for (TreeNode rightSubtree : rightSubtrees) {
                    trees.add(new TreeNode(i, leftSubtree, rightSubtree));
                }
            }
        }
        return trees;
    }
}
// @lc code=end

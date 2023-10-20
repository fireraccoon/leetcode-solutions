/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        dfs(ans, counts, root, 0);
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) / counts.get(i));
        }
        return ans;
    }
    void dfs(List<Double> ans, List<Integer> counts, TreeNode root, int deepth) {
        if (root == null) {
            return;
        }
        if (ans.size() == deepth) {
            ans.add(0D);
            counts.add(0);
        }
        ans.set(deepth, ans.get(deepth) + root.val);
        counts.set(deepth, counts.get(deepth) + 1);
        dfs(ans, counts, root.left, deepth + 1);
        dfs(ans, counts, root.right, deepth + 1);
    }
}
// @lc code=end


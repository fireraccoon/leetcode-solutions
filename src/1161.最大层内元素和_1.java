/*
 * @lc app=leetcode.cn id=1161 lang=java
 *
 * [1161] 最大层内元素和
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
    public int maxLevelSum(TreeNode root) {
        List<Integer> levelSums = new ArrayList<>();
        dfs(levelSums, root, 0);
        int level = 0;
        for (int i = 1; i < levelSums.size(); i++) {
            if (levelSums.get(i) > levelSums.get(level)) {
                level = i;
            }
        }
        return level + 1;
    }
    void dfs(List<Integer> levelSums, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == levelSums.size()) {
            levelSums.add(0);
        }
        levelSums.set(depth, levelSums.get(depth) + root.val);
        dfs(levelSums, root.left, depth + 1);
        dfs(levelSums, root.right, depth + 1);
    }
}
// @lc code=end


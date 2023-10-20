/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */

import java.util.HashMap;
import java.util.Map;

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
    Map<Long, Integer> prefixSums = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        prefixSums.put(0L, 1);
        return dfs(root, 0, targetSum);
    }
    int dfs(TreeNode root, long prefixSum, long targetSum) {
        if (root == null) {
            return 0;
        }
        prefixSum += root.val;
        int counter = prefixSums.getOrDefault(prefixSum - targetSum, 0);
        prefixSums.put(prefixSum, prefixSums.getOrDefault(prefixSum, 0) + 1);
        counter += dfs(root.left, prefixSum, targetSum);
        counter += dfs(root.right, prefixSum, targetSum);
        prefixSums.put(prefixSum, prefixSums.get(prefixSum) - 1);
        return counter;
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    public int pathSum(TreeNode root, int targetSum) {
        return dfs(root, new ArrayList<>(), targetSum);
    }
    int dfs(TreeNode root, List<Integer> path, long targetSum) {
        if (root == null) {
            return 0;
        }
        int counter = root.val == targetSum ? 1 : 0;
        long sum = root.val;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == targetSum) {
                counter++;
            }
        }
        path.add(root.val);
        counter += dfs(root.left, path, targetSum);
        counter += dfs(root.right, path, targetSum);
        path.remove(path.size() - 1);
        return counter;
    }
}
// @lc code=end


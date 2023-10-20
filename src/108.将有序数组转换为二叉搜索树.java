/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 */

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildSubTrees(nums, 0, nums.length - 1);
    }
    TreeNode buildSubTrees(int[] nums, int left, int right) {
        if (left == right) {
            return new TreeNode(nums[left]);
        } else if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        return new TreeNode(
            nums[middle],
            buildSubTrees(nums, left, middle - 1),
            buildSubTrees(nums, middle + 1, right)
        );
    }
}
// @lc code=end

